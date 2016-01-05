package fr.sigl.intg.controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Objects;
import javax.servlet.http.Part;

import fr.sigl.intg.model.Image;
import fr.sigl.intg.model.ImageDAO;
import fr.sigl.intg.model.Tag;
import fr.sigl.intg.model.TagDAO;
import fr.sigl.intg.model.Userlogin;
import fr.sigl.intg.model.UserloginDAO;

/** 
 *  {@Création d'un fiche de tag, @Création d'un dossier de support judiciaire, @Edition d'une fiche de tag, @Rechercher parmi les fiches de tag}
 */
public class TagController {

	public void SaveOrUpdateTag(Tag tag, Part filePart) {
		TagDAO tagDAO = new TagDAO();

		tagDAO.merge(tag);
		
		if (filePart != null && !filePart.getSubmittedFileName().equals("")) {
            try {
				Image image = new Image();
				image.setTag((Tag) tagDAO.findByExample(tag).get(0));
				InputStream inputStream = filePart.getInputStream();	
				DataInputStream dataIs = new DataInputStream(inputStream);
				byte[] imgBytes = new byte[(int)filePart.getSize()];
				dataIs.readFully(imgBytes);
				image.setImgBytes(imgBytes);
				
				ImageDAO imageDAO = new ImageDAO();
				imageDAO.persist(image);
				Set<Image> images = tag.getImages();
				images.add((Image) imageDAO.findByExample(image).get(0));
				tag.setImages(images);
				tagDAO.merge(tag);
				
            } catch (IOException e) {
				e.printStackTrace();
			}
        }
		
	}

	public List searchTags(String name, String authorFirstName, String authorLastName, String responsibleUser) {
		
		TagDAO tagDAO = new TagDAO();
		List tagList = new ArrayList<>();
		boolean shouldBeEmpty = false;

        Tag tagEntity = new Tag();
        if (!Objects.equals(name, ""))
        	tagEntity.setTagName(name);
        if (!Objects.equals(authorFirstName, ""))
            tagEntity.setTagAuthorfirstname(authorFirstName);
        if (!Objects.equals(authorLastName, ""))
            tagEntity.setTagAuthorlastname(authorLastName);
        if (!Objects.equals(responsibleUser, ""))
        {
    		UserloginDAO userloginDAO = new UserloginDAO();
    		Userlogin tmp = new Userlogin();
    		tmp.setUserLogin(responsibleUser);
    		
    		List userList = userloginDAO.findByExample(tmp);
    		
    		if (!userList.isEmpty()) {
    			Userlogin userlogin = (Userlogin) userloginDAO.findByExample(tmp).get(0);
    			tagEntity.setUserlogin(userlogin);
    		} else {
    			shouldBeEmpty = true;
    		}

        }

        if (!shouldBeEmpty)
        	tagList = tagDAO.findByExample(tagEntity);

        return tagList;
	}

	public void generateReport(Tag tag) {
	}
	
	// Edition d'une fiche de tag
	public void editTag(Connection db, int id) {
	}

	// Création des fiches de tag
	public void createNewTag(String name, String userConnected, String support, String support_specificity,
			String place, String size, String technique, String trash, String author_firstname, String author_lastname,
			String isVerified, Part filePart, String comment) {
		
		Tag newTag = new Tag();
		newTag.setTagName(name);
		newTag.setTagSupport(support);
		newTag.setTagSupportspecificity(support_specificity);
		newTag.setTagPlace(place);
		newTag.setTagSize(size);
		newTag.setTagUsedtechnique(technique);
		newTag.setTagTrashleft(trash);
		newTag.setTagAuthorfirstname(author_firstname);
		newTag.setTagAuthorlastname(author_lastname);
		newTag.setTagIdverified(Boolean.valueOf(isVerified));
		newTag.setTagRegistrationdate(new Date(Calendar.getInstance().getTime().getTime()));
		newTag.setTagComment(comment);
		
		UserloginDAO userloginDAO = new UserloginDAO();
		Userlogin userlogin = new Userlogin();
		userlogin.setUserLogin(userConnected);
		userlogin = (Userlogin) userloginDAO.findByExample(userlogin).get(0);
		newTag.setUserlogin(userlogin);
		
		TagDAO tagDAO = new TagDAO();
		tagDAO.persist(newTag);
		
		if (filePart != null && !filePart.getSubmittedFileName().equals("")) {
            try {
				Image image = new Image();
				image.setTag((Tag) tagDAO.findByExample(newTag).get(0));
				InputStream inputStream = filePart.getInputStream();	
				DataInputStream dataIs = new DataInputStream(inputStream);
				byte[] imgBytes = new byte[(int)filePart.getSize()];
				dataIs.readFully(imgBytes);
				image.setImgBytes(imgBytes);
				
				ImageDAO imageDAO = new ImageDAO();
				imageDAO.persist(image);
				Set<Image> images = newTag.getImages();
				images.add((Image) imageDAO.findByExample(image).get(0));
				newTag.setImages(images);
				tagDAO.merge(newTag);
				
            } catch (IOException e) {
				e.printStackTrace();
			}
        }

	}

	public List findAllTags() {
		TagDAO tagDAO = new TagDAO();
		Tag tag = new Tag();
		
		return tagDAO.findByExample(tag);
	}

	public byte[] getImageBytes(int imageId) {
		ImageDAO imageDAO = new ImageDAO();
		Image image = imageDAO.findById(imageId);
		
		return image.getImgBytes();
	}
		
	public Tag getTag(int tagId) {
		
		TagDAO tagDAO = new TagDAO();
		return tagDAO.findById(tagId);
	}

}