package ru.mail.aslanisl.test.presentation;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.mail.aslanisl.test.App;
import ru.mail.aslanisl.test.R;
import ru.mail.aslanisl.test.api.ApiService;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_tabs) TabLayout tabLayout;
    @BindView(R.id.main_viewpager) ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.getAppComponent().inject(this);
        ButterKnife.bind(this);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
