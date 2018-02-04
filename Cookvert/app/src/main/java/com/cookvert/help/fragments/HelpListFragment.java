package com.cookvert.help.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cookvert.R;
import com.cookvert.help.HelpManager;
import com.cookvert.help.adapters.HelpItemRecyclerViewAdapter;

public class HelpListFragment extends Fragment{
    /**
     * A simple {@link Fragment} subclass.
     * Activities that contain this fragment must implement the
     * {@link HelpListFragment.OnHelpListFragmentInteractionListener} interface
     * to handle interaction events.
     */
    private OnHelpListFragmentInteractionListener mListener;

    public HelpListFragment() {
        // Required empty public constructor
    }

    public static HelpListFragment newInstance(){
        HelpListFragment fragment = new HelpListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_help_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            //TODO put the list of topics as parameter
            recyclerView.setAdapter(new HelpItemRecyclerViewAdapter(
                    HelpManager.getInstance().getHelpTopics(), mListener));
        }

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnHelpListFragmentInteractionListener) {
            mListener = (OnHelpListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnHelpListFragmentInteractionListener");
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnHelpListFragmentInteractionListener {
        void onHelpListFragmentInteraction(
                HelpItemRecyclerViewAdapter.ViewHolder item, int itemPosition);
        void setHelpListAdapter(HelpItemRecyclerViewAdapter adapter);
    }
}
