package controllers;

import models.ContactModel;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class ContactController extends Controller {

	static Form<ContactModel> form = new Form<ContactModel>(ContactModel.class);

	public static Result index() {
		return ok(views.html.contact_index.render(ContactModel.find.all()));
	}

	public static Result get(Integer contactId) {
		return TODO;
	}

	public static Result create() {
		return ok(views.html.contact_create.render(form));
	}

	public static Result update(Integer contactId) {
		return TODO;
	}

	public static Result save() {
		Form<ContactModel> f = form.bindFromRequest();
		f.get().save();
		return redirect(routes.ContactController.index());
	}

	public static Result delete(Integer contactId) {
		return TODO;
	}
}
