package com.heady.ecommerce.example.view;

import com.heady.ecommerce.example.db.entity.Ranking;
import com.heady.ecommerce.example.db.entity.category.Category;

import java.util.ArrayList;

/**
 * Created by ayyazkhan on 18/10/18.
 */

public interface IMainActivityView {

    void setHierarchyCategories(ArrayList<Category> hierarchyCategories);
    void showChildCategoriesDetails(ArrayList<Category> childCategories);
    void showRankingDetails(ArrayList<Ranking> rankings);


}
