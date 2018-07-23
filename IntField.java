package application;

public class IntField extends AbstractNumField<Integer> implements Input<Integer>{

	public IntField(String s) {
		super(s);
		value = 0;
	}
	public IntField() {
		super();
//		txtDescription = new TextField();

		value = 0;
		
	}
	
	public Integer getValue() {
		if (super.getText() != null) {
			value = Integer.parseInt(super.getText());
		}
		else {
			value = 0;
		}

		return value;
	}
	
}


