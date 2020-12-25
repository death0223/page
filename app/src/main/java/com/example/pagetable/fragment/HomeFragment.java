package com.example.pagetable.fragment;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.pagetable.R;
import com.example.pagetable.adatper.BannerSingleAdatper;
import com.example.pagetable.adatper.BrandlGridAdatper;
import com.example.pagetable.adatper.ChannelGridAdatper;
import com.example.pagetable.adatper.HotGoodGridAdatper;
import com.example.pagetable.adatper.NewGoodGridAdatper;
import com.example.pagetable.adatper.PersonSingleAdatper;
import com.example.pagetable.adatper.PinSingleAdatper;
import com.example.pagetable.adatper.SouSingleAdatper;
import com.example.pagetable.adatper.XinSingleAdatper;
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


        //第一行
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        SouSingleAdatper souSingleAdatper = new SouSingleAdatper(getActivity(), singleLayoutHelper);

        //第二行
        SingleLayoutHelper singleLayoutHelper2 = new SingleLayoutHelper();
        singleLayoutHelper2.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper2.setPadding(10, 10, 10, 10);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        bannerlist = new ArrayList<>();
        BannerSingleAdatper bannerSingleAdatper = new BannerSingleAdatper(getActivity(), singleLayoutHelper2, this.bannerlist);

        //第三行
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        gridLayoutHelper.setPadding(10, 10, 10, 10);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离//        gridLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        gridLayoutHelper.setSpanCount(5);// 设置每行多少个网格;
        title = new ArrayList<>();
        channelGridAdatper = new ChannelGridAdatper(getActivity(),gridLayoutHelper,title);

        //第四行
        SingleLayoutHelper singleLayoutHelper3 = new SingleLayoutHelper();
        singleLayoutHelper3.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper3.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        PinSingleAdatper pinSingleAdatper = new PinSingleAdatper(getActivity(), singleLayoutHelper3);

        //第五行
        GridLayoutHelper gridLayoutHelper2 = new GridLayoutHelper(2);
        gridLayoutHelper2.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离//        gridLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        gridLayoutHelper2.setSpanCount(2);// 设置每行多少个网格;
        brandListBeans = new ArrayList<>();
        brandlGridAdatper = new BrandlGridAdatper(getActivity(),gridLayoutHelper2,brandListBeans);

        //第六行
        SingleLayoutHelper singleLayoutHelper4 = new SingleLayoutHelper();
        singleLayoutHelper3.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper3.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        XinSingleAdatper xinSingleAdatper = new XinSingleAdatper(getActivity(), singleLayoutHelper4);

        //第七行
        GridLayoutHelper gridLayoutHelper3 = new GridLayoutHelper(2);
        gridLayoutHelper3.setPadding(15, 15, 15, 15);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离//        gridLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        gridLayoutHelper3.setSpanCount(2);// 设置每行多少个网格;
        newList = new ArrayList<>();
        newGoodGridAdatper = new NewGoodGridAdatper(getActivity(), gridLayoutHelper3, newList);

        //第八行
        SingleLayoutHelper singleLayoutHelper5 = new SingleLayoutHelper();
        singleLayoutHelper5.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper5.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        PersonSingleAdatper personSingleAdatper = new PersonSingleAdatper(getActivity(), singleLayoutHelper5);

//        //第九行
        GridLayoutHelper gridLayoutHelper4 = new GridLayoutHelper(1);
        gridLayoutHelper4.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离//        gridLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        gridLayoutHelper4.setSpanCount(1);// 设置每行多少个网格;
        hotGoodsListBeans = new ArrayList<>();
        hotGoodGridAdatper = new HotGoodGridAdatper(getActivity(), gridLayoutHelper4, hotGoodsListBeans);

        adapter = new DelegateAdapter(manager, false);
        adapter.addAdapter(souSingleAdatper);//第一行
        adapter.addAdapter(bannerSingleAdatper);//第二行
        adapter.addAdapter(channelGridAdatper);//第三行
        adapter.addAdapter(pinSingleAdatper);//第四行
        adapter.addAdapter(brandlGridAdatper);//第五行
        adapter.addAdapter(xinSingleAdatper);//第六行
        adapter.addAdapter(this.newGoodGridAdatper);//第七行
        adapter.addAdapter(personSingleAdatper);//第八行
        adapter.addAdapter(hotGoodGridAdatper);//第九行
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

        adapter.notifyDataSetChanged();


    }

    @Override
    public void getError(String string) {

    }
}