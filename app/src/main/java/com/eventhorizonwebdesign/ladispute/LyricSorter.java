package com.eventhorizonwebdesign.ladispute;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import com.eventhorizonwebdesign.ladispute.listutils.ExpandListAdapter;
import com.eventhorizonwebdesign.ladispute.listutils.ExpandListChild;
import com.eventhorizonwebdesign.ladispute.listutils.ExpandListGroup;
import com.eventhorizonwebdesign.ladispute.listutils.LyricListAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LyricSorter extends AppCompatActivity {
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    public static ExpandListAdapter ExpAdapter;
    protected static ArrayList<ExpandListGroup> ExpListItems;
    protected static ExpandableListView ExpandList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyric_sorter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);






    }

    public static ArrayList<ExpandListGroup> SetStandardGroups(Context c) {
        ArrayList<ExpandListGroup> list = new ArrayList<>();
        ArrayList<ExpandListChild> list2 = new ArrayList<>();
        ExpandListGroup gru1 = new ExpandListGroup();
        gru1.setName(c.getString(R.string.album_vancouver));
        String[] tempArray = c.getResources().getStringArray(R.array.album_array_vancouver);
        int count = 0;
        int max = tempArray.length;
        do {
            ExpandListChild ch = new ExpandListChild();
            ch.setName(tempArray[count]);
            ch.setTag(null);
            list2.add(ch);
            count++;
        } while(count < max);
        gru1.setItems(list2);
        list.add(gru1);


        list2 = new ArrayList<>();
        ExpandListGroup gru2 = new ExpandListGroup();
        gru2.setName(c.getString(R.string.album_satbotrbvaa));
        tempArray = c.getResources().getStringArray(R.array.album_array_satbotrbvaa);
        count = 0;
        max = tempArray.length;
        do {
            ExpandListChild ch = new ExpandListChild();
            ch.setName(tempArray[count]);
            ch.setTag(null);
            list2.add(ch);
            count++;
        } while(count < max);
        gru2.setItems(list2);
        list.add(gru2);

        list2 = new ArrayList<>();
        ExpandListGroup gru3 = new ExpandListGroup();
        gru3.setName(c.getString(R.string.album_wildlife));
        tempArray = c.getResources().getStringArray(R.array.album_array_wildlife);
        count = 0;
        max = tempArray.length;
        do {
            ExpandListChild ch = new ExpandListChild();
            ch.setName(tempArray[count]);
            ch.setTag(null);
            list2.add(ch);
            count++;
        } while(count < max);
        gru3.setItems(list2);
        list.add(gru3);

        list2 = new ArrayList<>();
        ExpandListGroup gru4 = new ExpandListGroup();
        gru4.setName(c.getString(R.string.album_rooms));
        tempArray = c.getResources().getStringArray(R.array.album_array_rooms);
        count = 0;
        max = tempArray.length;
        do {
            ExpandListChild ch = new ExpandListChild();
            ch.setName(tempArray[count]);
            ch.setTag(null);
            list2.add(ch);
            count++;
        } while(count < max);
        gru4.setItems(list2);
        list.add(gru4);

        return list;
    }



    /**
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lyric_sorter, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
     **/

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 1:
                    return getString(R.string.section_songs);
                case 2:
                    return getString(R.string.section_album);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView;
            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1:
                    rootView = inflater.inflate(R.layout.fragment_lyric_sorter_songs, container, false);
                    TextView textView = (TextView) rootView.findViewById(R.id.section_label);
                    textView.setText(getPageTitle(getArguments().getInt(ARG_SECTION_NUMBER)));
                    ListView lyricsList = (ListView) rootView.findViewById(R.id.lyricsList);
                    String[] tempArray1 = this.getContext().getResources().getStringArray(R.array.album_array_vancouver);
                    String[] tempArray2 = this.getContext().getResources().getStringArray(R.array.album_array_satbotrbvaa);
                    tempArray1 = arrayConcat(tempArray1, tempArray2);
                    tempArray2 = this.getContext().getResources().getStringArray(R.array.album_array_wildlife);
                    tempArray1 = arrayConcat(tempArray1, tempArray2);
                    tempArray2 = this.getContext().getResources().getStringArray(R.array.album_array_rooms);
                    tempArray1 = arrayConcat(tempArray1, tempArray2);
                    List<String> titles = Arrays.asList(tempArray1);
                    Collections.sort(titles, String.CASE_INSENSITIVE_ORDER);
                    final LyricListAdapter customAdapter = new LyricListAdapter(rootView.getContext(), R.layout.expandlist_child_item, titles);
                    lyricsList.setAdapter(customAdapter);
                    lyricsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(rootView.getContext(), LyricActivity.class);
                            intent.putExtra("SONG_TITLE", customAdapter.getItem(position));
                            startActivity(intent);
                        }
                    });
                    break;
                case 2:
                    rootView = inflater.inflate(R.layout.fragment_lyric_sorter_albums, container, false);
                    TextView textView2 = (TextView) rootView.findViewById(R.id.section_label);
                    textView2.setText(getPageTitle(getArguments().getInt(ARG_SECTION_NUMBER)));
                    ExpandableListView ExpandList = (ExpandableListView) rootView.findViewById(R.id.lyricsExpList);
                    ExpListItems = SetStandardGroups(rootView.getContext());
                    ExpAdapter = new ExpandListAdapter(rootView.getContext(), ExpListItems);
                    ExpandList.setAdapter(ExpAdapter);
                    ExpandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                        @Override
                        public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                            Intent intent = new Intent(rootView.getContext(), LyricActivity.class);
                            intent.putExtra("SONG_TITLE", ExpAdapter.getChildTitle(groupPosition, childPosition));
                            startActivity(intent);
                            return false;
                        }
                    });
                    break;
                default:
                    //something broke.
                    rootView = inflater.inflate(R.layout.fragment_lyric_sorter_albums, container, false);
                    break;
            }
            return rootView;
        }

        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 1:
                    return getString(R.string.section_songs);
                case 2:
                    return getString(R.string.section_album);
            }
            return null;
        }

        public String[] arrayConcat(String[] a, String[] b) {
            int aLen = a.length;
            int bLen = b.length;
            String[] c= new String[aLen+bLen];
            System.arraycopy(a, 0, c, 0, aLen);
            System.arraycopy(b, 0, c, aLen, bLen);
            return c;
        }
    }


}
