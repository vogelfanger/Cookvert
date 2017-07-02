package com.cookvert.recipes.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cookvert.R;
import com.cookvert.conversion.ConvertManager;
import com.cookvert.recipes.RecipeManager;
import com.cookvert.recipes.adapters.MyIngredientRecyclerViewAdapter;
import com.cookvert.recipes.model.Ingredient;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p>
 * Activities containing this fragment MUST implement the {@link OnOriginalListFragmentInteractionListener}
 * interface.
 */
public class OriginalRecipeFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_ADAPTER_LIST = "adapter_list";
    private List<Ingredient> adapterList; //argument list for the adapter
    private OnOriginalListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public OriginalRecipeFragment() {
    }

    /**
     * Instantiates a new fragment with parameters. Parameter determines whether which list is used for the list adapter
     * @param adapterId 1 uses list from ConvertManager, 0 uses list from RecipeManager
     * @return
     */
    public static OriginalRecipeFragment newInstance(int adapterId) {
        OriginalRecipeFragment fragment = new OriginalRecipeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ADAPTER_LIST, adapterId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ingredient_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            //New adapter parameter
            recyclerView.setAdapter(new MyIngredientRecyclerViewAdapter(getRecipeList(), mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnOriginalListFragmentInteractionListener) {
            mListener = (OnOriginalListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * Help method that finds the right recipe list for the fragment instance.
     * @return List of ingredients from the original recipe
     */
    private List<Ingredient> getRecipeList(){
        //if argument is 0, get list for EditRecipeActivity
        if(getArguments().getInt(ARG_ADAPTER_LIST) == 0){
            return RecipeManager.getInstance().getFocusedRecipe().getIngredients();
        //if argument is 1, get list for ConvertActivity
        }else if(getArguments().getInt(ARG_ADAPTER_LIST) == 1){
            return ConvertManager.getInstance().getOriginalIngredientList();
        }else{
            return new ArrayList<Ingredient>();
        }

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnOriginalListFragmentInteractionListener {
        void onOriginalListFragmentInteraction(MyIngredientRecyclerViewAdapter.ViewHolder item, int itemPosition);
        void setOriginalRecipeAdapter(MyIngredientRecyclerViewAdapter adapter);
    }
}
