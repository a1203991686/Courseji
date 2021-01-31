package com.example.middle.ui.student;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.middle.R;
import com.example.middle.logic.model.ItemData;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MyAdapter extends BaseQuickAdapter<ItemData.AllSignData, BaseViewHolder> {


    public MyAdapter(int layoutResId, @Nullable List<ItemData.AllSignData> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ItemData.AllSignData itemData) {
        baseViewHolder.setText(R.id.middle_item_theme,itemData.getTheme())
                .setText(R.id.middle_item_stateButton,itemData.getStateTitle())
                .setText(R.id.middle_item_labelTextView,itemData.getLabelTitle())
                .setText(R.id.middle_item_timeTextView,itemData.getStartTime()+"至"+itemData.getEndTime())
                .setBackgroundColor(R.id.middle_item_viewColor,itemData.getLeftColor())
                .setBackgroundColor(R.id.middle_item_stateButton,itemData.getLeftColor());
    }
}
