package py.una.entidad;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ClienteJSON {


    public static void main(String[] args) throws Exception {
    	ClienteJSON representacion = new ClienteJSON();
    	
    	/*System.out.println("Ejemplo de uso 1: pasar de objeto a string");
    	Cliente p = new Cliente();
    	p.setNombre("Maria");
    	p.setApellido("Gomez");
    	p.setCedula(123456L);
    	p.getAsignaturas().add("Algoritmos y Estructuras de Datos 2");
    	p.getAsignaturas().add("Quimica");
    	p.getAsignaturas().add("Ingles");
    	
    	String r1 = representacion.objetoString(p);
    	System.out.println(r1);
    	
    	
    	System.out.println("\n*************************************************************************");
    	System.out.println("\nEjemplo de uso 2: pasar de string a objeto");
    	String un_string = "{\"cedula\":123123,\"nombre\":\"Ana\",\"apellido\":\"Perez\",\"asignaturas\":[\"Sistemas Distribuidos\",\"Fisica\",\"Inteligencia Artificial\"]}";
    	
    	Cliente r2 = representacion.stringObjeto(un_string);
    	System.out.println(r2.nombre + " " + r2.apellido + " " +r2.cedula );
        for(String temp: r2.getAsignaturas()){
        	System.out.println(temp);
        }*/
    }
    
    public static String objetoString(Cliente p) {
    	
		JSONObject obj = new JSONObject();
        obj.put("idcliente", p.getIdcliente());
        obj.put("cliente", p.getCliente());
        obj.put("moneda", p.getMoneda());
        obj.put("valor_compra", p.getValor_compra());
        obj.put("valor_venta", p.getValor_venta());


        /*JSONArray list = new JSONArray();
        
        for(String temp: p.getAsignaturas()){
        	list.add(temp);
        }
       // if(list.size() > 0) {
        	obj.put("asignaturas", list);
        //}*/
        

        return obj.toJSONString();
    }
    
    
    public static Cliente stringObjeto(String str) throws Exception {
    	Cliente p = new Cliente();
        JSONParser parser = new JSONParser();

        Object obj = parser.parse(str.trim());
        JSONObject jsonObject = (JSONObject) obj;

        Long idcliente = (Long) jsonObject.get("idcliente");
        p.setIdcliente(idcliente);
        p.setCliente((String)jsonObject.get("cliente"));
        p.setMoneda((String)jsonObject.get("moneda"));
        p.setValor_compra((String)jsonObject.get("valor_compra"));
        p.setValor_venta((String)jsonObject.get("valor_venta"));
        
       /* JSONArray msg = (JSONArray) jsonObject.get("asignaturas");
        Iterator<String> iterator = msg.iterator();
        while (iterator.hasNext()) {
        	p.getAsignaturas().add(iterator.next());
        }*/
        return p;
	}

}
