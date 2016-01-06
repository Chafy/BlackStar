package test;

import org.testng.annotations.Test;

import fr.sigl.intg.model.Tag;
import fr.sigl.intg.model.TagDAO;

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
    assert(true);
  }
}
