/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.controlador;

import java.util.List;
import paquete.modelo.Aspirante;
import paquete.modelo.Carrera;
import paquete.modelo.Inscripcion;
import paquete.modelo.Rector;
import paquete.modelo.Universidad;


/**
 *
 * @author Estudiante
 */
public class GestionDato {
    private List<Aspirante> AspiranteList;
    private List<Universidad> UniversidadList;
    private List<Carrera> CarreraList;
    private List<Inscripcion> InscripcionList;
    private List<Rector> RectorList;

    public GestionDato(List<Aspirante> AspiranteList, List<Universidad> UniversidadList, List<Carrera> CarreraList, List<Inscripcion> InscripcionList, List<Rector> RectorList) {
        this.AspiranteList = AspiranteList;
        this.UniversidadList = UniversidadList;
        this.CarreraList = CarreraList;
        this.InscripcionList = InscripcionList;
        this.RectorList = RectorList;
    }
     public boolean addAspirante(Aspirante aspirante) {
        
	return this.AspiranteList.add(aspirante);
    }
    public boolean addUniversidad(Universidad universidad) {
        
	return this.UniversidadList.add(universidad);
    }
    public boolean addCarrera(Carrera carrera) {
        
	return this.CarreraList.add(carrera);
    }
    public boolean addInscripcion(Inscripcion inscripcion) {
        
	return this.InscripcionList.add(inscripcion);
    }
    public boolean addRector(Rector rector) {
        
	return this.RectorList.add(rector);
    }
    
    
     public Rector buscarRector(String x) {
		Rector retorno= null;
		for(Rector r: this.RectorList)
		{
			if(r.getNombre()==x) {
				retorno=r;
			}
		}
		return retorno;
	}

   public Universidad buscarUniversidad(String x) {
		Universidad retorno= null;
		for(Universidad u: this.UniversidadList)
		{
			if(u.getNombre()==x) {
				retorno=u;
			}
		}
		return retorno;
	}
     public Carrera buscarCarrera(String x) {
		Carrera retorno= null;
		for(Carrera ca: this.CarreraList)
		{
			if(ca.getNombre()==x) {
				retorno=ca;
			}
		}
		return retorno;
	}
      public Aspirante buscarAspirante(String x) {
		Aspirante retorno= null;
		for(Aspirante as: this.AspiranteList)
		{
			if(as.getNombre()==x) {
				retorno=as;
			}
		}
		return retorno;
	}
      public Carrera buscarNomApe(String n,String a) {
		Carrera retorno= null;
		for(Inscripcion na: this.InscripcionList)
		{
			if(na.getAspirante().getNombre()==n && na.getAspirante().getApellido()==a) {
				retorno=na.getCarrera();
			}
		}
		return retorno;
	}
    

    public List<Aspirante> getAspiranteList() {
        return AspiranteList;
    }

    public void setAspiranteList(List<Aspirante> AspiranteList) {
        this.AspiranteList = AspiranteList;
    }

    public List<Universidad> getUniversidadList() {
        return UniversidadList;
    }

    public void setUniversidadList(List<Universidad> UniversidadList) {
        this.UniversidadList = UniversidadList;
    }

    public List<Carrera> getCarreraList() {
        return CarreraList;
    }

    public void setCarreraList(List<Carrera> CarreraList) {
        this.CarreraList = CarreraList;
    }

    public List<Inscripcion> getInscripcionList() {
        return InscripcionList;
    }

    public void setInscripcionList(List<Inscripcion> InscripcionList) {
        this.InscripcionList = InscripcionList;
    }

    public List<Rector> getRectorList() {
        return RectorList;
    }

    public void setRectorList(List<Rector> RectorList) {
        this.RectorList = RectorList;
    }
    
}
