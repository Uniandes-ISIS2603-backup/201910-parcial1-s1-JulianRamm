/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.recipes.entities;

import javax.persistence.ManyToOne;

/**
 *
 * @author je.osorio
 */
public class IngredientEntity {
    private String name;
    private Long calorias;
    private Long id;
    @ManyToOne
    private RecipeEntity receta;
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the calorias
     */
    public Long getCalorias() {
        return calorias;
    }

    /**
     * @param calorias the calorias to set
     */
    public void setCalorias(Long calorias) {
        this.calorias = calorias;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    public IngredientEntity(){
        
    }

    /**
     * @return the receta
     */
    public RecipeEntity getReceta() {
        return receta;
    }

    /**
     * @param receta the receta to set
     */
    public void setReceta(RecipeEntity receta) {
        this.receta = receta;
    }
}
