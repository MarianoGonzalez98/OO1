package ar.edu.unlp.oo1.ejercicio1.impl;

import ar.edu.unlp.oo1.ejercicio1.WallPost;

/**
 * Completar esta clase de acuerdo a lo especificado en el cuadernillo
 *
 */
public class WallPostImpl implements WallPost {

	/**
	 * Complete con su implementación
	 */
	private String texto;
	private int cantLikes;
	private boolean esDestacado;
	
	
	/*
	* Permite construir una instancia del WallpostImpl.
	* Luego de la invocación, debe tener como texto: “Undefined post”,
	* no debe estar marcado como destacado y la cantidad de “Me gusta” deben ser 0.
	*/
	public WallPostImpl() {
		texto="Undefined post";
		cantLikes=0;
		esDestacado=false;
	}
	/*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de forma adecuada
	 */
    @Override
    public String toString() {
        return "WallPost {" +
            "text: " + getText() +
            ", likes: '" + getLikes() + "'" +
            ", featured: '" + isFeatured() + "'" +
            "}";
    }

	@Override
	public String getText() {
		return texto;
	}

	@Override
	public void setText(String text) {
		texto=text;
		
	}

	@Override
	public int getLikes() {
		return cantLikes;
	}

	@Override
	public void like() {
		cantLikes++;
		
	}

	@Override
	public void dislike() {
		if (cantLikes!=0)
			cantLikes--;
		
	}

	@Override
	public boolean isFeatured() {
		return esDestacado;
	}

	@Override
	public void toggleFeatured() {
		esDestacado=!esDestacado;
	}

	//comentario test

}
