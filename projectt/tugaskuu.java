import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PagableList;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;

public class tugaskuu {

/*
A simple Facebook4J client which
illustrates how to access group feeds / posts / comments.
@param args
@throws FacebookException 
*/
public static void main(String[] args) throws FacebookException {

 // Generate facebook instance.
Facebook facebook = new FacebookFactory().getInstance();
// Use default values for oauth app id.
facebook.setOAuthAppId("193291338290318", "c058d29a4f2f5bd218bd3d5f0f2bd7db");
// Get an access token from: 
// https://developers.facebook.com/tools/explorer
// Copy and paste it below.
String accessTokenString ="EAACvzCWOlI4BAO0c0DjokZAVJwLHnNQ31IRqK121MZCeBbiPdY8XpUDZB7vXNShZBWK3W9rDV8UAGFNpLHqRUgyvprevZBRtXkghQk5rYgCN2j7hThP2jRHsmSSmh7FxkxuygGbCPZCLpx9ZCtYRnDkIFNhIRLNZAJZC6u2JXgeSWGydujJAERZCz1WGuojaLsEpUNAPZC8u8N1lQZDZD";
AccessToken at = new AccessToken(accessTokenString);
// Set access token.
facebook.setOAuthAccessToken(at);

 // We're done.
// Access group feeds.
// You can get the group ID from:
// https://developers.facebook.com/tools/explorer

 // Set limit to 25 feeds.

ResponseList< Post > feeds = facebook.getFeed("2245314562224028",
new Reading().limit(25));



 // For all 25 feeds...
for (int i = 0; i < feeds.size(); i++) {
// Get post.
Post post = feeds.get(i);
// Get (string) message.
String message = post.getMessage();
// Print out the message.
System.out.println(message);
PagableList comments = post.getComments();
String date = post.getCreatedTime().toString();
// String name = post.getFrom().getName();
String id = post.getId();
System.out.println(date);
System.out.println(id);
}
 }	
}