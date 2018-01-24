package yimin.sun.imagepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.Arrays;
import java.util.List;

/**
 * 注意，由于使用了Fresco来加载图片，请确保Fresco已初始化 - Fresco.initialize()
 */
public class ImagePager extends ViewPager {

    private ScalingUtils.ScaleType scaleType;

    public ImagePager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setData(List<?> data, DataConverter converter) {
        setAdapter(new ImagePagerAdapter(data, converter));
    }

    public void setData(List<String> data) {
        setData(data, new DataConverter() {
            @Override
            public String dataToString(Object data) {
                return (String) data;
            }
        });
    }

    public void setData(String[] data) {
        setData(Arrays.asList(data));
    }


    public void setScaleType(ScalingUtils.ScaleType scaleType) {
        this.scaleType = scaleType;
    }

    public interface DataConverter {
        String dataToString(Object data);
    }

    private class ImagePagerAdapter extends PagerAdapter {

        List<?> data;
        DataConverter converter;

        ImagePagerAdapter(List<?> data, DataConverter converter) {
            this.data = data;
            this.converter = converter;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            Context context = container.getContext();
            View view = LayoutInflater.from(context).inflate(R.layout.item_1, container, false);
            container.addView(view);

            SimpleDraweeView draweeView = (SimpleDraweeView) view.findViewById(R.id.drawee);
            if (scaleType != null) {
                draweeView.getHierarchy().setActualImageScaleType(scaleType);
            }
            draweeView.setImageURI(converter.dataToString(data.get(position)));

            return view;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return data == null ? 0 : data.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
