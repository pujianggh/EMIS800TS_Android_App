package com.stype.pickerview.adapter;

import com.stype.wheelview.adapter.WheelAdapter;

import java.util.List;

/**
 * @author pujiang
 * @date 2018-5-24 13:31
 * @mail 515210530@qq.com
 * @Description:
 */
public class ArrayWheelAdapter<T> implements WheelAdapter {
	

	// items
	private List<T> items;

	/**
	 * Constructor
	 * @param items the items
	 */
	public ArrayWheelAdapter(List<T> items) {
		this.items = items;

	}
	
	@Override
	public Object getItem(int index) {
		if (index >= 0 && index < items.size()) {
			return items.get(index);
		}
		return "";
	}

	@Override
	public int getItemsCount() {
		return items.size();
	}

	@Override
	public int indexOf(Object o){
		return items.indexOf(o);
	}

}
