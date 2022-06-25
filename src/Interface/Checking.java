package Interface;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Checking {
	public static void checkEmpty(JTextField text) throws EmptyTextFormException {
		if (text.getText().equals("")) {
			throw new EmptyTextFormException(text.getName());
		}
	}
	public static void checkNotSelected(JComboBox cb) throws NotSelectedException {
		String selected=(String)cb.getSelectedItem();
		if (selected.equals("<Seleccione>")) {
			throw new NotSelectedException(cb.getName());
		}
	}
}
