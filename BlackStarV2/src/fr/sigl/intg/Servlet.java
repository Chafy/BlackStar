package fr.sigl.intg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import fr.sigl.intg.controller.LoginController;
import fr.sigl.intg.controller.TagController;
import fr.sigl.intg.controller.UserController;
import fr.sigl.intg.model.Tag;
import fr.sigl.intg.model.Userlogin;

@MultipartConfig
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = -4099191990249828904L;

	private String userConnected = "";
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LoginController loginController = new LoginController();
		TagController tagController = new TagController();
		UserController userController = new UserController();
		
		String url = request.getRequestURI();
		
		if (userConnected.equals("") && !url.equals("/BlackStarV2/login")) {
			request.setAttribute("errorMessage", "Vous devez d'abord vous identifier.");
			request.getRequestDispatcher("/login_BLACKSTAR.jsp").forward(request, response);
		}
			
		request.setAttribute("userConnected", userConnected);
		
		switch (url) {
			case "/BlackStarV2/login":
				String login = request.getParameter("login_form");
				String password = request.getParameter("password_form");
				if (loginController.submitLogin(login, password)) {
					userConnected = login;
					response.sendRedirect("/BlackStarV2/tags");
				} else
					request.getRequestDispatcher("/login_BLACKSTAR.jsp").forward(request, response);
				break;
			case "/BlackStarV2/tags":
				request.setAttribute("tagList", tagController.findAllTags());
				request.getRequestDispatcher("/mainpage_admin_BLACKSTAR.jsp").forward(request, response);
			case "/BlackStarV2/search_tags":
				String name_searchform = request.getParameter("name_searchform");
				String author_lastname_searchform = request.getParameter("author_lastname_searchform");
				String author_firstname_searchform = request.getParameter("author_firstname_searchform");
				String login_searchform = request.getParameter("login_searchform");
				
				request.setAttribute("tagList", tagController.searchTags(name_searchform, author_firstname_searchform,
						author_lastname_searchform, login_searchform));
				
				request.getRequestDispatcher("/mainpage_admin_BLACKSTAR.jsp").forward(request, response);
			case "/BlackStarV2/add":
				request.getRequestDispatcher("/addNewTag_BLACKSTAR.jsp").forward(request,response);
				break;
			case "/BlackStarV2/create_tag":
				String name = request.getParameter("tag_name");
				String user_id = request.getParameter("tag_responsible");
				String support = request.getParameter("tag_support");
				String support_specificity= request.getParameter("tag_support_specificity");
				String place = request.getParameter("tag_place");
				String size = request.getParameter("tag_size");
				String technique = request.getParameter("tag_technique");
				String trash = request.getParameter("tag_trash");
				String author_firstname = request.getParameter("tag_author_firstname");
				String author_lastname = request.getParameter("tag_author_lastname");
				String isVerified = request.getParameter("tag_isVerified");
				Part filePart = request.getPart("image_chooser");
				String comment = request.getParameter("tag_comment");
				tagController.createNewTag(name, userConnected, support, support_specificity,
						place, size, technique, trash, author_firstname,
						author_lastname, isVerified, filePart, comment);
				response.sendRedirect("/BlackStarV2/tags");
				break;
			case "/BlackStarV2/edit":
				int tagIdToEdit = Integer.parseInt(request.getParameter("tagId"));
				Tag tagToEdit = tagController.getTag(tagIdToEdit);
				request.setAttribute("tag", tagToEdit);
				request.getRequestDispatcher("/editTag_BLACKSTAR.jsp").forward(request,response);
				break;
			case "/BlackStarV2/save_modifications":
				int tagId = Integer.parseInt(request.getParameter("tagId"));
				Tag tagToUpdate = tagController.getTag(tagId);
				
				tagToUpdate.setTagName(request.getParameter("tag_name"));
				tagToUpdate.setTagSupport(request.getParameter("tag_support"));
				tagToUpdate.setTagSupportspecificity(request.getParameter("tag_support_specificity"));
				tagToUpdate.setTagPlace(request.getParameter("tag_place"));
				tagToUpdate.setTagSize(request.getParameter("tag_size"));
				tagToUpdate.setTagUsedtechnique(request.getParameter("tag_technique"));
				tagToUpdate.setTagTrashleft(request.getParameter("tag_trash"));
				tagToUpdate.setTagAuthorfirstname(request.getParameter("tag_author_firstname"));
				tagToUpdate.setTagAuthorlastname(request.getParameter("tag_author_lastname"));
				tagToUpdate.setTagIdverified(Boolean.valueOf(request.getParameter("tag_idVerified")));
				tagToUpdate.setTagComment(request.getParameter("tag_comment"));
				
				Part filePart2 = request.getPart("image_chooser");
				
				tagController.SaveOrUpdateTag(tagToUpdate, filePart2);
				
				response.sendRedirect("/BlackStarV2/tags");
				break;
			case "/BlackStarV2/gestion":
				request.getRequestDispatcher("/user_administration_BLACKSTAR.jsp").forward(request, response);
				break;
			case "/BlackStarV2/add_user":
				String newUserLogin = request.getParameter("login_userform");
				String newUser_password = request.getParameter("password_userform");
				String newUser_type = request.getParameter("type_userform");
				userController.addUser(newUserLogin, newUser_password, newUser_type);
				request.getRequestDispatcher("/user_administration_BLACKSTAR.jsp").forward(request, response);
				break;
			case "/BlackStarV2/display_img":
				String selectedImageId = request.getParameter("selectedImageId");
				byte[] content = tagController.getImageBytes(Integer.parseInt(selectedImageId));
				response.setContentType("image/png");
                response.setContentLength(content.length);
                response.getOutputStream().write(content);
				break;
			default:
				break;
		}
	}
}
