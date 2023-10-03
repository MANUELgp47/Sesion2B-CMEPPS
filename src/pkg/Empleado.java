package pkg;

public class Empleado {
	
	public enum TipoEmpleado{Vendedor, Encargado};
	
	public float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {
		float salarioBruto;
		
		if (tipo == TipoEmpleado.Vendedor)
			salarioBruto = 2000;
		else
			salarioBruto = 2500;
		
		if (ventasMes >= 1500)
			salarioBruto += 200;
		else if (ventasMes >= 1000)
			salarioBruto += 100;
		
		salarioBruto += horasExtra*30;
		
		
		return salarioBruto;
		
	}
	
	public float calculaNominaNeta(float nominaBruta) {
		
		float nominaNeta= nominaBruta;
		
		if (nominaBruta > 2100 && nominaBruta < 2500)
			nominaNeta = (float) (nominaBruta - (nominaBruta * 0.15));
		else if (nominaBruta >= 2500)
			nominaNeta = (float) (nominaBruta - (nominaBruta * 0.18));
		
		return nominaNeta;
	}

}
