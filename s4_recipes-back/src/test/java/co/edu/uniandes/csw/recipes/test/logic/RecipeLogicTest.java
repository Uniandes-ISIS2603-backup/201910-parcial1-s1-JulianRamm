/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.recipes.test.logic;

import co.edu.uniandes.csw.recipes.ejb.RecipeLogic;
import co.edu.uniandes.csw.recipes.entities.IngredientEntity;
import co.edu.uniandes.csw.recipes.entities.RecipeEntity;
import co.edu.uniandes.csw.recipes.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.recipes.persistence.RecipePersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author je.osorio
 */
@RunWith(Arquillian.class)
public class RecipeLogicTest {
    private static final Logger LOGGER = Logger.getLogger(RecipePersistence.class.getName());
    
    @PersistenceContext(unitName = "recipesPU")
    protected EntityManager em;
    @Inject
    private RecipeLogic logic;
    @Test
    public void CreateRecipeTest() throws BusinessLogicException{
        RecipeEntity a=new RecipeEntity();        
        a.setName("dfs");
        a.setDescription("svdsd");
        IngredientEntity in=new IngredientEntity();
        em.persist(in);
        ArrayList<IngredientEntity> ingrs=new ArrayList<IngredientEntity>();
        ingrs.add(in);
        a.setIngredients(ingrs);
        em.persist(a);
        RecipeEntity re=logic.createRecipe(a);
        Assert.assertNotNull(re);
        RecipeEntity as=em.find(RecipeEntity.class, re.getId());
        Assert.assertEquals(re.getName(), as.getName());
    }
    @Test(expected = BusinessLogicException.class)
    public void CreateRecipeTestfail() throws BusinessLogicException{
        RecipeEntity a=new RecipeEntity();        
        a.setName("");
        a.setDescription("svdsd");
        
        em.persist(a);
        RecipeEntity re=logic.createRecipe(a);       
    }
    @Test(expected = BusinessLogicException.class)
    public void CreateRecipeTestfail2() throws BusinessLogicException{
        RecipeEntity a=new RecipeEntity();        
        a.setName("sa");
        a.setDescription("");
        IngredientEntity in=new IngredientEntity();
        em.persist(in);
        ArrayList<IngredientEntity> ingrs=new ArrayList<IngredientEntity>();
        ingrs.add(in);
        a.setIngredients(ingrs);
        em.persist(a);
        RecipeEntity re=logic.createRecipe(a);       
    }
    @Test(expected = BusinessLogicException.class)
    public void CreateRecipeTestfail3() throws BusinessLogicException{
        RecipeEntity a=new RecipeEntity();        
        a.setName("sa");
        a.setDescription("vffd");
        IngredientEntity in=new IngredientEntity();
        em.persist(in);
        ArrayList<IngredientEntity> ingrs=new ArrayList<IngredientEntity>();
        em.persist(a);
        RecipeEntity b=new RecipeEntity();        
        b.setName("sa");
        b.setDescription("vffda");
        b.setIngredients(ingrs);
        RecipeEntity re=logic.createRecipe(b);       
    }
    @Test(expected = BusinessLogicException.class)
    public void CreateRecipeTestfail4() throws BusinessLogicException{
        RecipeEntity a=new RecipeEntity();        
        a.setName("sa");
        a.setDescription("");     
        ArrayList<IngredientEntity> ingrs=new ArrayList<IngredientEntity>();      
        a.setIngredients(ingrs);
        em.persist(a);
        RecipeEntity re=logic.createRecipe(a);       
    }
}
