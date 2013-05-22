package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class ContactModel extends Model {

	@Id
	public Integer contactId;

	@Column(length = 65)
	@Required
	public String name;
	public String phone;

	public static final Finder<Integer, ContactModel> find = new Finder<Integer, ContactModel>(
			Integer.class, ContactModel.class);

	public ContactModel(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
}
