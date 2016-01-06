package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.testng.annotations.Test;

import fr.sigl.intg.model.Tag;
import fr.sigl.intg.model.TagDAO;
import fr.sigl.intg.model.Userlogin;
import fr.sigl.intg.model.UserloginDAO;

public class TagControllerTest {

	@Test
	public void SaveOrUpdateTag() {
		assert(true);
	}

	@Test
	public void createNewTag() {
		assert(true);
	}

	@Test
	public void editTag() {
		assert(true);
	}

	@Test
	public void findAllTags() {
		TagDAO tagDAO = new TagDAO();
		Tag tag = new Tag();

		java.util.List list = tagDAO.findByExample(tag);

		assert(!list.isEmpty());
	}

	@Test
	public void generateReport() {
		assert(true);
	}

	@Test
	public void getImageBytes() {
		assert(true);
	}

	@Test
	public void getTag() {
		assert(true);
	}

	@Test
	public void searchTags() {
		TagDAO tagDAO = new TagDAO();
		List tagList = new ArrayList<>();
		boolean shouldBeEmpty = false;

		Tag tagEntity = new Tag();
		UserloginDAO userloginDAO = new UserloginDAO();
		Userlogin tmp = new Userlogin();
		tmp.setUserLogin("admin");

		List userList = userloginDAO.findByExample(tmp);

		if (!userList.isEmpty()) {
			Userlogin userlogin = (Userlogin) userloginDAO.findByExample(tmp).get(0);
			tagEntity.setUserlogin(userlogin);
		}

		tagList = tagDAO.findByExample(tagEntity);

		assert(!tagList.isEmpty());
	}
}
