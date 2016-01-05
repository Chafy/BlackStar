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

	//private Connection connection = null;
	private String userConnected = "";
	
	/*public void init(ServletConfig config) throws ServletException {
	try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/blackstar","postgres", "root");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}*/
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LoginController loginController = new LoginController();
		TagController tagController = new TagController();
		UserController userController = new UserController();
		
		String url = request.getRequestURI();
		
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
				tagController.createNewTag(name, userConnected, support, support_specificity,
						place, size, technique, trash, author_firstname,
						author_lastname, isVerified, filePart);
				response.sendRedirect("/BlackStarV2/tags");
				break;
			case "/BlackStarV2/edit":
				int tagId = Integer.parseInt(request.getParameter("tagId"));
				Tag tag = tagController.getTag(tagId);
				request.setAttribute("tag", tag);
				request.getRequestDispatcher("/editTag_BLACKSTAR.jsp").forward(request,response);
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
			default:
				break;
		}

		/*TagController tagController = new TagController();
		LoginController loginController = new LoginController();
		String url = req.getRequestURI();
		List<String[]> tagList = tagController.findAllTags(connection);
		req.setAttribute("tagList", tagList);

		switch (url) {
			case "/BlackStarV2/tags":
				req.getRequestDispatcher("/mainpage_admin_BLACKSTAR.jsp").forward(req,resp);
			case "/BlackStarV2/login":
				String login = req.getParameter("login_form");
				String password = req.getParameter("password_form");
				if (loginController.login(connection, login, password)) {
					userConnected = login;
					resp.sendRedirect("/BlackStarV2/tags");
				}
				else
					req.getRequestDispatcher("/login_BLACKSTAR.jsp").forward(req,resp);				
				break;
			case "/BlackStarV2/add":
				req.getRequestDispatcher("/addNewTag_BLACKSTAR.jsp").forward(req,resp);
				break;
			case "/BlackStarV2/create_tag":
				String name = req.getParameter("tag_name");
				String user_id = req.getParameter("tag_responsible");
				String support = req.getParameter("tag_support");
				String support_specificity= req.getParameter("tag_support_specificity");
				String place = req.getParameter("tag_place");
				String size = req.getParameter("tag_size");
				String technique = req.getParameter("tag_technique");
				String trash = req.getParameter("tag_trash");
				String author_firstname = req.getParameter("tag_author_firstname");
				String author_lastname = req.getParameter("tag_author_lastname");
				String isVerified = req.getParameter("tag_isVerified");
				tagController.createNewTag(connection, name, userConnected, support, support_specificity,
						place, size, technique, trash, author_firstname,
						author_lastname, isVerified);
				resp.sendRedirect("/BlackStarV2/tags");
				break;
			case "/BlackStarV2/edit":
				req.setAttribute("tag", tagController.findById(connection, Integer.parseInt(req.getParameter("tagId"))));
				req.getRequestDispatcher("/editTag_BLACKSTAR.jsp").forward(req, resp);
				break;
			case "/BlackStarV2/gestion":
				req.getRequestDispatcher("/user_administration_BLACKSTAR.jsp").forward(req, resp);
				break;
			default:
				break;
		}*/
	}
}
