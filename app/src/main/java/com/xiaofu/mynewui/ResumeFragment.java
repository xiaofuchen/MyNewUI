package com.xiaofu.mynewui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ResumeFragment extends Fragment {
    private static final String KEY = "position";

    private ImageView iv1, iv2;
    private TextView tv_name, tv_resume;

    private static final int res1[] = {R.mipmap.jiaju1, R.mipmap.paul1, R.mipmap.shirong1, R.mipmap.jiaqiang1};
    private static final int res2[] = {R.mipmap.jiaju2, R.mipmap.paul2, R.mipmap.shirong2, R.mipmap.jiaqiang2};
    private static final String name[] = {"黄家驹", "黄贯中", "叶世荣", "黄家强"};
    private static final String resume[] = {
            "黄家驹，1962年6月10日出生于香港，中国香港男歌手、原创音乐人、吉他手、摇滚乐队Beyond主唱及创队成员。1983年以歌曲《大厦》出道，并担任Beyond乐队的主唱。1988年凭借专辑《秘密警察》在香港歌坛获得关注，其中由黄家驹创作的歌曲《大地》获得十大劲歌金曲奖。1989年黄家驹作曲的歌曲《真的爱你》获得十大劲歌金曲奖以及十大中文金曲奖[5]。1990年凭借歌曲《光辉岁月》获得十大劲歌金曲最佳填词奖。1991年在香港红馆举行《Beyond生命接触演唱会》。1992年赴日本发展歌唱事业。1993年黄家驹创作的歌曲《海阔天空》获得十大中文金曲奖以及叱咤乐坛流行榜我最喜爱的本地创作歌曲大奖；6月24日，在日本参与某综艺节目期间意外受伤，6月30日逝世，终年31岁；同年，被追颁十大中文金曲奖《无休止符纪念奖》。 黄家驹有独特的沙哑嗓音，对尾音的颤抖式处理成为他的标志。他擅长词曲创作以及吉他弹奏，Beyond在1983年到1993年这段时期发表的大部分音乐作品均为黄家驹作曲及主唱。",
            "黄贯中（Paul Wong），1964年3月31日生于中国香港，男歌手、音乐人、香港摇滚乐队Beyond的主音吉他手。1985年加入Beyond。1987年随Beyond发行EP《永远等待》。1988年发行的粤语歌曲《大地》由黄贯中演唱，并获得88年度十大劲歌金曲奖。黄家驹意外去世后，他与Beyond其他成员继续以乐队名义发展。1999年Beyond宣布暂时分开发展，黄贯中开始独自发展音乐事业。2001年推出首张个人专辑《Yellow Paul Wong》并夺得“2001叱咤乐坛唱作人金奖”。2002年再次凭借专辑《Play it loud》夺得“叱咤乐坛唱作人金奖”，两年间连续夺得该大奖使其奠定了唱作人地位。同年成立独立唱片公司“polar bear”。2004年Ovation为黄贯中生产全球首支以华人吉他手为名的Ovation <黄贯中> 木吉他。2005年1月随Beyond在香港体育馆开始举行“Beyond The Story Live 2005”世界巡回告别演唱会并宣布解散。2008年6月10日黄贯中参与黄家强举办的“海阔天空”音乐会的演出。2010年11月27日他与朱茵携手出席《2010星尚大典》颁奖典礼。2012年10月与朱茵办理结婚手续成为夫妻，同年获得12届华语音乐传媒大奖“最佳粤语男歌手”和“最佳摇滚艺人”奖。",
            "叶世荣（Yip Sai Wing），1963年8月19日出生于中国香港，歌手、音乐人、BEYOND乐队鼓手及创队成员[1]  。1983年，与黄家驹等人组成了中国香港摇滚乐队BEYOND，并担任乐队的鼓手。1993年6月，黄家驹在日本东京意外去世，叶世荣与BEYOND其他成员继续以乐队名义发展。1999年12月，BEYOND宣布暂时解散，叶世荣开始发展自己的音乐事业。2001年8月，推出首张个人唱片《美丽的时光机器》。2003年，叶世荣与BEYOND队友黄贯中、黄家强复出歌坛，并举行“Beyond超越Beyond”世界巡回演唱会。2005年，Beyond乐队正式解散。2008年6月10日，参与Beyond队友黄家强举办的“海阔天空”音乐会的演出；同年11月8日，与Beyond队友黄贯中在新加坡举办“Beyond Next Stage Live 2008”演唱会。2013年11月，获得音乐先锋榜年度最佳先锋创作歌手、年度先锋摇滚歌手奖项。2015年9月，推出专辑《引以为荣》。", "" +
            "黄家强1964年11月13日出生在中国香港，祖籍广东省台山市，创作歌手、摇滚乐队Beyond贝斯手，已故歌手黄家驹的弟弟。 1983年，黄家强加入Beyond并担任贝斯手，还兼任主唱、作曲、填词及编曲等工作，直至2005年乐队解散。1988年因演唱歌曲《冷雨夜》而受到关注。1994年推出专辑《二楼后座》。2002年，因首张个人专辑《Be Right Back》获得IFPI香港唱片销量大奖“最畅销本地男新人奖”。2004年凭借歌曲《长空》获得第23届香港电影金像奖最佳原创电影歌曲。2013年6月举行“Its Alright Live 2013演唱会”。"};

    public static ResumeFragment Instant(int postion) {
        ResumeFragment f = new ResumeFragment();
        Bundle b = new Bundle();
        b.putInt(KEY, postion);
        f.setArguments(b);
        return f;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_resume, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iv1 = (ImageView) view.findViewById(R.id.iv1);
        iv2 = (ImageView) view.findViewById(R.id.iv2);
        tv_name = (TextView) view.findViewById(R.id.tv_name);
        tv_resume = (TextView) view.findViewById(R.id.tv_resume);
        int postion = getArguments().getInt(KEY, 0);
        iv1.setImageResource(res1[postion]);
        iv2.setImageResource(res2[postion]);
        tv_name.setText(name[postion]);
        tv_resume.setText(resume[postion]);
    }
}
