package Power.PowerPAF;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.yasson.internal.JsonbRiParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Feedback;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("Feedback")
public class FeedbackService {
	Feedback FeedbackObj = new Feedback();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readApprovements() {
		return FeedbackObj.Feedbacks();
	}
		
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertFeedback(@FormParam("Customer_Name") String FeedbackName,
			@FormParam("Customer_Email") String FeedbackEmail, @FormParam("Feedback_Subject") String FeedbackSubject,
			@FormParam("Feedback_Message") String FeedbackMessage) {
		String output = FeedbackObj.insertFeedback(FeedbackName, FeedbackEmail, FeedbackSubject, FeedbackMessage);
		return output;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateProduct(String FeedbackData) {
		// Convert the input string to a JSON object
		JsonObject productObject = new JsonbRiParser(null).parse(FeedbackData).getAsJsonObject();
		// Read the values from the JSON object
		String FeedbackId = productObject.get ("Customer_Id").getAsString();
		String FeedbackName = productObject.get("Customer_Name").getAsString();
		String FeedbackEmai = productObject.get("Customer_Email").getAsString();
		String FeedbackSubject = productObject.get("Feedback_Subject").getAsString();
		String FeedbackMessage = productObject.get("Feedback_Message").getAsString();
		String output = FeedbackObj.updatefeedback(FeedbackName, FeedbackEmai, FeedbackSubject, FeedbackMessage);
	return output;		
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteFeedback(String FeedbackData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(FeedbackData, "", Parser.xmlParser());

		// Read the value from the element <itemID>
		String FeedbackId = doc.select("FeedbackID").text();
		String output = FeedbackObj.deleteFeedback(FeedbackId);
		return output;

	
	
    }
}
