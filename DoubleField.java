package application;

public class DoubleField extends AbstractNumField<Double> implements Input<Double>{
	
	public DoubleField() {
		super();
		value = 0.0;
	}
	public DoubleField(String s) {
		super(s);
		value = 0.0;
	}
	public Double getValue() {
		value = Double.parseDouble(super.getText());
		return value;
	}

}
