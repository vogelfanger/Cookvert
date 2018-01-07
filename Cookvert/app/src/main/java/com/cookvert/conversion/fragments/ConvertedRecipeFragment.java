package com.cookvert.conversion.fragments;

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
import com.cookvert.conversion.adapters.MyConvertedIngredientRecyclerViewAdapter;
import com.cookvert.recipes.model.Ingredient;

import java.util.List;

/**
 * Fragment containing the list of converted ingredients.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnConvertedListFragmentInteractionListener}
 * interface.
 */
public class ConvertedRecipeFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    private static final String ARG_SECTION_NUMBER = "section_number";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    private OnConvertedListFragmentInteractionListener mListener;
    private RecyclerView recyclerView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ConvertedRecipeFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ConvertedRecipeFragment newInstance(int sectionNumber, int columnCount) {
        ConvertedRecipeFragment fragment = new ConvertedRecipeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_converted_ingredient_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyConvertedIngredientRecyclerViewAdapter(getRecipeList(), mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnConvertedListFragmentInteractionListener) {
            mListener = (OnConvertedListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnConvertedListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * Help method that finds the right recipe list for the fragment instance.
     * @return List of ingredients from the converted recipe
     */
    private List<Ingredient> getRecipeList(){
            return ConvertManager.getInstance().getConvertedIngredientList();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnConvertedListFragmentInteractionListener {
        void onConvertedListFragmentInteraction(MyConvertedIngredientRecyclerViewAdapter.ViewHolder item, int itemPosition);
        void setConvertedRecipeAdapter(MyConvertedIngredientRecyclerViewAdapter adapter);
        void onContextMenuCreated(int itemPosition);
    }
}
