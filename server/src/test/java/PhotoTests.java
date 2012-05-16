import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.handstandtech.facebook.server.CachingFacebookAPIImpl;
import com.handstandtech.facebook.server.FacebookAPI;
import com.handstandtech.facebook.shared.model.FacebookPhoto;

public class PhotoTests extends TestCase {

	private static final String AUTH_TOKEN = "166223179475|0fbfe05768b05f09dbe1c9eb-6216557|0nNP-ZNsF6KbMDu9x3jIRHEAbrU";

	private static FacebookAPI api = new CachingFacebookAPIImpl(AUTH_TOKEN);

	@Test
	public void testGetPhotos() {
		String uid = "25502900";
		List<FacebookPhoto> photos = api.getRecentPhotosForUser(uid, 10);
		System.out.println(photos.size() + " photos.");
		assertEquals("Correct # of Photos", 10, photos.size());
	}
}
