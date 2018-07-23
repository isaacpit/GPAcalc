package application;

import javafx.scene.control.TextField;

interface Input<T> {
	
	abstract T getValue();
	
}

public abstract class AbstractNumField<T> extends TextField implements Input<T>{
	T value;
	
	public AbstractNumField (String s) {
		super(s);
	}
	public AbstractNumField () {
		super();
	}
//	public abstract T getValue();
//	abstract T getValue();
}
