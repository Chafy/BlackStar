package fr.sigl.intg.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.sigl.intg.model.Tag;

/** 
 *  {@Cr�ation d'un fiche de tag, @Cr�ation d'un dossier de support judiciaire, @Edition d'une fiche de tag, @Rechercher parmi les fiches de tag}
 */
public class TagController {

	public void SaveOrUpdateTag(Tag tag) {
	}

	public void searchTags(Connection db, String name, String authorFirstName, String authorLastName, String responsibleUser) {
	}

	public void generateReport(Tag tag) {
	}

	// Cr�ation des fiches de tag
	public void createNewTag(Connection db, String name, String user_id, String support,
			String support_specificity, String place, String size,
			String technique, String trash, String author_firstname,
			String author_lastname, String isVerified) {

		int user_idBDD = 0;
		try {
			Statement st = db.createStatement( 
					ResultSet.TYPE_SCROLL_SENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);
			String sql = String.format("SELECT user_id FROM userlogin WHERE user_login='%s';",
	                user_id);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				user_idBDD = rs.getInt("user_id");
			}
			
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Statement st = db.createStatement( 
					ResultSet.TYPE_SCROLL_SENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);
			Boolean idVerified = (isVerified != null);
			String sql = String.format("INSERT INTO tag("
            + "id, user_id, name, registrationdate, support, supportspecificity, "
            + "place, size, author_fisrtname, author_lastname, idverified, usedtechnique, "
            + "trashleft, comment) "
            + "VALUES (default, %d, '%s', current_date, '%s', '%s', "
            + "'%s', '%s', '%s', '%s', %b, '%s', "
            + "'%s', '%s');",
            user_idBDD, name, support, support_specificity, place, size, author_firstname, 
            author_lastname, idVerified, technique, trash, "");
			st.executeUpdate(sql);

			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Edition d'une fiche de tag
	public void editTag(Connection db, int id) {
	}

	/*public List<String[]> findAllTags(Connection db) {
		List<String[]> tagList = new ArrayList<>();
		
		try {
			Statement st = db.createStatement( 
					ResultSet.TYPE_SCROLL_SENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);
			String sql = String.format("SELECT name, author_fisrtname, author_lastname, "
					+ "registrationDate, user_login, id FROM tag JOIN userlogin ON "
					+ "userlogin.user_id = tag.user_id;");
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String[] newRow = new String[6];
				newRow[0] = rs.getString("name");
				newRow[1] = rs.getString("author_fisrtname");
				newRow[2] = rs.getString("author_lastname");
				newRow[3] = rs.getString("registrationDate");
				newRow[4] = rs.getString("user_login");
				newRow[5] = rs.getString("id");
				tagList.add(newRow);
			}
			
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tagList;
	}*/

	/*public Tag findById(Connection db, int tagId) {
		Tag tag = null;
		try {
			Statement st = db.createStatement( 
					ResultSet.TYPE_SCROLL_SENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);
			String sql = String.format("SELECT id, name, registrationdate, support, supportspecificity, "
					+ "place, size, author_fisrtname, author_lastname, idverified, usedtechnique, "
					+ "trashleft, comment, user_login, id FROM tag a "
					+ "JOIN userlogin b ON "
					+ "b.user_id = a.user_id WHERE id = " + tagId + ";");
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("name");
				Date registrationDate = rs.getDate("registrationDate");
				String support = rs.getString("support");
				String supportSpecificity = rs.getString("supportspecificity");
				String place = rs.getString("place");
				String size = rs.getString("size");
				String author_firstname = rs.getString("author_fisrtname");
				String author_lastname = rs.getString("author_lastname");
				Boolean idVerified = rs.getBoolean("idVerified");
				String usedTechnique = rs.getString("usedtechnique");
				String trashLeft = rs.getString("trashleft");
				String comment = rs.getString("comment");
				String user_login = rs.getString("user_login");
				Integer id = rs.getInt("id");
				tag = new Tag(name, registrationDate, support, supportSpecificity,
						place, size, author_firstname, author_lastname, idVerified, usedTechnique,
						trashLeft, comment, id, user_login);
			}
			
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tag;
	}*/

}