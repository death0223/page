package com.example.pagetable.fragment;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.pagetable.R;
import com.example.pagetable.SouActivity;
import com.example.pagetable.adatper.BannerSingleAdatper;
import com.example.pagetable.adatper.BrandlGridAdatper;
import com.example.pagetable.adatper.CategorySingleAdatper;
import com.example.pagetable.adatper.ChannelGridAdatper;
import com.example.pagetable.adatper.HotGoodGridAdatper;
import com.example.pagetable.adatper.NewGoodGridAdatper;
import com.example.pagetable.adatper.PersonSingleAdatper;
import com.example.pagetable.adatper.PinSingleAdatper;
import com.example.pagetable.adatper.SouSingleAdatper;
import com.example.pagetable.adatper.TopicSingleAdatper;
import com.example.pagetable.adatper.XinSingleAdatper;
import com.example.pagetable.adatper.ZhuanSingleAdatper;
import com.example.pagetable.base.FragmentBase;
import com.example.pagetable.bean.ListBean;
import com.example.pagetable.contract.Contract;
import com.example.pagetable.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends FragmentBase<HomePresenter> implements Contract.InView {

    private RecyclerView rel;
    private DelegateAdapter adapter;
    private ArrayList<ListBean.DataBean.BannerBean> bannerlist;
    private ArrayList<ListBean.DataBean.ChannelBean> title;
    private ArrayList<ListBean.DataBean.BrandListBean> brandListBeans;
    private ChannelGridAdatper channelGridAdatper;
    private BrandlGridAdatper brandlGridAdatper;
    private ArrayList<ListBean.DataBean.NewGoodsListBean> newList;
    private NewGoodGridAdatper newGoodGridAdatper;
    private ArrayList<ListBean.DataBean.HotGoodsListBean> hotGoodsListBeans;
    private HotGoodGridAdatper hotGoodGridAdatper;
    private ArrayList<ListBean.DataBean.TopicListBean> topicListBeans;
    private TopicSingleAdatper topicSingleAdatper;
    private CategorySingleAdatper categorySingleAdatper;
    private ArrayList<ListBean.DataBean.CategoryListBean> categoryListBeans;
    private SouSingleAdatper souSingleAdatper;


    @Override
    protected void initLister() {
        //搜索框
        souSingleAdatper.setOnClick(new SouSingleAdatper.OnClick() {
            @Override
            public void onClick(int position) {
                startActivity(new Intent(getActivity(), SouActivity.class));
            }
        });
    }

    @Override
    protected HomePresenter getfrag() {
        return new HomePresenter(this);
    }

    protected void initDate() {
        present.getDate();
    }

    protected void initView(View view) {
        rel = view.findViewById(R.id.home_rel);
        VirtualLayoutManager manager = new VirtualLayoutManager(getActivity());
        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();
        rel.setRecycledViewPool(pool);
        pool.setMaxRecycledViews(0, 10);


        //第一行  搜索框
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setBgColor(Color.WHITE);
        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        souSingleAdatper = new SouSingleAdatper(getActivity(), singleLayoutHelper);

        //第二行  banner
        SingleLayoutHelper singleLayoutHelper2 = new SingleLayoutHelper();
        singleLayoutHelper2.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper2.setPadding(10, 10, 10, 10);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        bannerlist = new ArrayList<>();
        singleLayoutHelper2.setBgColor(Color.WHITE);
        BannerSingleAdatper bannerSingleAdatper = new BannerSingleAdatper(getActivity(), singleLayoutHelper2, this.bannerlist);

        //第三行 分类
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        gridLayoutHelper.setPadding(45, 45, 45, 45);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离//        gridLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        gridLayoutHelper.setSpanCount(5);// 设置每行多少个网格;
        title = new ArrayList<>();
        gridLayoutHelper.setBgColor(Color.WHITE);
        channelGridAdatper = new ChannelGridAdatper(getActivity(),gridLayoutHelper,title);

        //第四行 品牌制造商直供
        SingleLayoutHelper singleLayoutHelper3 = new SingleLayoutHelper();
        singleLayoutHelper3.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper3.setMarginTop(30);
        singleLayoutHelper3.setBgColor(Color.WHITE);
        singleLayoutHelper3.setPadding(20, 20, 20, 30);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        PinSingleAdatper pinSingleAdatper = new PinSingleAdatper(getActivity(), singleLayoutHelper3);

        //第五行 品牌子布局
        GridLayoutHelper gridLayoutHelper2 = new GridLayoutHelper(2);
        gridLayoutHelper2.setPadding(20, 30, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离//        gridLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        gridLayoutHelper2.setSpanCount(2);// 设置每行多少个网格;
        gridLayoutHelper2.setBgColor(Color.WHITE);
        brandListBeans = new ArrayList<>();
        brandlGridAdatper = new BrandlGridAdatper(getActivity(),gridLayoutHelper2,brandListBeans);

        //第六行  新品首发
        SingleLayoutHelper singleLayoutHelper4 = new SingleLayoutHelper();
        singleLayoutHelper4.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper4.setBgColor(Color.WHITE);
        singleLayoutHelper4.setPadding(20, 20, 20, 40);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        XinSingleAdatper xinSingleAdatper = new XinSingleAdatper(getActivity(), singleLayoutHelper4);

        //第七行  新品首发子布局
        GridLayoutHelper gridLayoutHelper3 = new GridLayoutHelper(2);
        gridLayoutHelper3.setPadding(15, 25, 15, 60);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离//        gridLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        gridLayoutHelper3.setSpanCount(2);// 设置每行多少个网格;
        gridLayoutHelper3.setBgColor(Color.WHITE);
        newList = new ArrayList<>();
        newGoodGridAdatper = new NewGoodGridAdatper(getActivity(), gridLayoutHelper3, newList);

        //第八行 人气推荐
        SingleLayoutHelper singleLayoutHelper5 = new SingleLayoutHelper();
        singleLayoutHelper5.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper5.setBgColor(Color.WHITE);
        singleLayoutHelper5.setMarginTop(30);
        singleLayoutHelper5.setPadding(20, 20, 20, 40);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        PersonSingleAdatper personSingleAdatper = new PersonSingleAdatper(getActivity(), singleLayoutHelper5);

        //第九行  人气推荐子布局
        GridLayoutHelper gridLayoutHelper4 = new GridLayoutHelper(1);
        gridLayoutHelper4.setPadding(20, 30, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离//        gridLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        gridLayoutHelper4.setSpanCount(1);// 设置每行多少个网格;
        hotGoodsListBeans = new ArrayList<>();
        gridLayoutHelper4.setBgColor(Color.WHITE);
        hotGoodGridAdatper = new HotGoodGridAdatper(getActivity(), gridLayoutHelper4, hotGoodsListBeans);

        //第十行 专题精选
        SingleLayoutHelper singleLayoutHelper6 = new SingleLayoutHelper();
        singleLayoutHelper6.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper6.setBgColor(Color.WHITE);
        singleLayoutHelper6.setMarginTop(30);
        singleLayoutHelper6.setPadding(20, 20, 20, 40);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        ZhuanSingleAdatper zhuanSingleAdatper = new ZhuanSingleAdatper(getActivity(), singleLayoutHelper6);

        //第十一行 专题精选子布局
        SingleLayoutHelper singleLayoutHelper7 = new SingleLayoutHelper();
        singleLayoutHelper7.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper7.setBgColor(Color.WHITE);
        singleLayoutHelper7.setPadding(30, 30, 30, 30);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        topicListBeans = new ArrayList<>();
        topicSingleAdatper = new TopicSingleAdatper(getActivity(), topicListBeans,singleLayoutHelper7 );

        //第十二行  居家一系列
        SingleLayoutHelper singleLayoutHelper8 = new SingleLayoutHelper();
        singleLayoutHelper8.setItemCount(7);// 设置布局里Item个数
        singleLayoutHelper8.setBgColor(Color.WHITE);
        categoryListBeans = new ArrayList<>();
        categorySingleAdatper = new CategorySingleAdatper(getActivity(),singleLayoutHelper8, categoryListBeans );


        adapter = new DelegateAdapter(manager, false);
        adapter.addAdapter(souSingleAdatper);//第一行
        adapter.addAdapter(bannerSingleAdatper);//第二行
        adapter.addAdapter(channelGridAdatper);//第三行
        adapter.addAdapter(pinSingleAdatper);//第四行
        adapter.addAdapter(brandlGridAdatper);//第五行
        adapter.addAdapter(xinSingleAdatper);//第六行
        adapter.addAdapter(newGoodGridAdatper);//第七行
        adapter.addAdapter(personSingleAdatper);//第八行
        adapter.addAdapter(hotGoodGridAdatper);//第九行
        adapter.addAdapter(zhuanSingleAdatper);//第十行
        adapter.addAdapter(topicSingleAdatper);//第十一行
        adapter.addAdapter(categorySingleAdatper);//第十二行

        rel.setLayoutManager(manager);
        rel.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void getBean(Object object) {
        ListBean listBean= (ListBean) object;
        List<ListBean.DataBean.BannerBean> banner = listBean.getData().getBanner();
        bannerlist.addAll(banner);

        List<ListBean.DataBean.ChannelBean> channel = listBean.getData().getChannel();
        title.addAll(channel);
        channelGridAdatper.notifyDataSetChanged();

        List<ListBean.DataBean.BrandListBean> brandList = listBean.getData().getBrandList();
        brandListBeans.addAll(brandList);
        brandlGridAdatper.notifyDataSetChanged();

        List<ListBean.DataBean.NewGoodsListBean> newGoodsList = listBean.getData().getNewGoodsList();
        newList.addAll(newGoodsList);
        newGoodGridAdatper.notifyDataSetChanged();

        List<ListBean.DataBean.HotGoodsListBean> hotGoodsList = listBean.getData().getHotGoodsList();
        hotGoodsListBeans.addAll(hotGoodsList);
        hotGoodGridAdatper.notifyDataSetChanged();

        List<ListBean.DataBean.TopicListBean> topicList = listBean.getData().getTopicList();
        topicListBeans.addAll(topicList);
        topicSingleAdatper.notifyDataSetChanged();

        List<ListBean.DataBean.CategoryListBean> categoryList = listBean.getData().getCategoryList();
        categoryListBeans.addAll(categoryList);
        categorySingleAdatper.notifyDataSetChanged();

        adapter.notifyDataSetChanged();


    }

    @Override
    public void getError(String string) {

    }
}