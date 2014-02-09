package se.restful.xmlparser;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Nodes;
import se.guard.User;

public class UserParser
{
	
	private static final Builder builder = new Builder();

	public static User fromXml(final String userAsXml) throws Exception
		{
			final Element root = builder.build(userAsXml, null).getRootElement();
			final String id = queryForElementValue(root, "id");
			final int userid= Integer.parseInt(id);
			final String firstname = queryForElementValue(root, "firstname");
			final String lastname = queryForElementValue(root, "lastname");
			final String email = queryForElementValue(root, "email");
			final String password = queryForElementValue(root, "password");
	
			return new User(userid, firstname, lastname, email,password);
		}
	
		public static String toXml(final User user)
		{
			final Element root = new Element("users");
			final Element root1 = new Element("user");
	
			final Element id = new Element("id");
			final int userId=user.getUserid();
			String idd=userId+"";
			id.appendChild(idd);
			
			final Element firstname = new Element("firstname");
			firstname.appendChild(user.getFirstname());
			
			final Element lastname = new Element("lastname");
			lastname.appendChild(user.getLastname());
			
			final Element email = new Element("email");
			lastname.appendChild(user.getLastname());
			
			final Element password = new Element("password");
			lastname.appendChild(user.getLastname());
	
			root1.appendChild(id);
			root1.appendChild(firstname);
			root1.appendChild(lastname);
			root1.appendChild(email);
			root1.appendChild(password);
			root.appendChild(root1);
	
			return new Document(root).toXML();
		}
		
		private static String queryForElementValue(final Element element, final String query)
		{
			Nodes nodes = element.query(query);
	
			final Element e = nodes.size() > 0 ? (Element) element.query(query).get(0) : null;
			return e == null ? "" : e.getValue().trim();
		}

}
