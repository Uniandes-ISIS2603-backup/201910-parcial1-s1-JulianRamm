/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.recipes.ejb;

import co.edu.uniandes.csw.recipes.entities.RecipeEntity;
import co.edu.uniandes.csw.recipes.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.recipes.persistence.RecipePersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author CesarF
 */
@Stateless
public class RecipeLogic {
    @Inject
    private RecipePersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    public RecipeEntity getRecipe(Long id) {
        return persistence.find(id);
    }
    public RecipeEntity createRecipe(RecipeEntity recipeEntity) throws BusinessLogicException{
        if(recipeEntity.getName()==null||recipeEntity.getName().length()>30||recipeEntity.getName().equals("")){
            throw new BusinessLogicException("El nombre es invalido");
        }
        if(persistence.findByName(recipeEntity.getName())!=null){
            throw new BusinessLogicException("Ya existe");
        }
        if(recipeEntity.getDescription().equals("")||recipeEntity.getDescription()==null||recipeEntity.getDescription().length()>150){
            throw new BusinessLogicException("Descripcion invalida");
        }
        return persistence.createRecipe(recipeEntity);
    }
    //TODO crear el método createRecipe


}
