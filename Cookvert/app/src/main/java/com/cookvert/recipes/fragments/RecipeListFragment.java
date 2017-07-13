package com.cookvert.recipes.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;

import com.cookvert.R;
import com.cookvert.recipes.RecipeManager;
import com.cookvert.recipes.adapters.RecipeRecyclerViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecipeListFragment.OnRecipeListFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RecipeListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipeListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnRecipeListFragmentInteractionListener mListener;

    public RecipeListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecipeListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecipeListFragment newInstance(String param1, String param2) {
        RecipeListFragment fragment = new RecipeListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe_list, container, false);
        //set adapter
        final ExpandableListView listView = (ExpandableListView) view.findViewById(R.id.expandable_recipe_list);
        //TODO this is an issue when using the fragment in different places, use arguments instead
        listView.setAdapter(new RecipeRecyclerViewAdapter(RecipeManager.getInstance().recipeCategories, mListener));

        //add long click listener to both parent and child views
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {

                long packPosition = listView.getExpandableListPosition(position);
                int itemType = ExpandableListView.getPackedPositionType(packPosition);
                int groupPosition = ExpandableListView.getPackedPositionGroup(packPosition);
                int childPosition = ExpandableListView.getPackedPositionChild(packPosition);

                //category is clicked
                if(itemType == ExpandableListView.PACKED_POSITION_TYPE_GROUP){
                    mListener.onLongCategoryClick(view, groupPosition);
                }
                //long click interaction for child
                else if(itemType == ExpandableListView.PACKED_POSITION_TYPE_CHILD){
                    mListener.onLongChildClick(view, groupPosition, childPosition);
                }
                return true;
            }
        });

        //add basic click listener to child, parent's listener is not overridden
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view,
                                        int groupPosition, int childPosition, long l) {

                //basic list interaction for child
                mListener.onRecipeListFragmentInteraction(groupPosition, childPosition);
                return true;
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRecipeListFragmentInteractionListener) {
            mListener = (OnRecipeListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
    public interface OnRecipeListFragmentInteractionListener {
        void onRecipeListFragmentInteraction(int categoryPosition, int recipePosition);
        void onLongCategoryClick(View view, int categoryPosition);
        void onLongChildClick(View view, int categoryPosition, int childPosition);
        void setRecipeListAdapter(RecipeRecyclerViewAdapter adapter);
    }
}
