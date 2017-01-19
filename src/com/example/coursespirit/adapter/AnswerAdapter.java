package com.example.coursespirit.adapter;

import java.util.List;

import com.example.coursespirit.R;
import com.example.coursespirit.db.Answer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AnswerAdapter extends ArrayAdapter<Answer> {
	private int resourceId;
	public AnswerAdapter(Context context, int textViewResourceId, List<Answer> objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Answer answer = getItem(position); // ��ȡ��ǰ���Fruitʵ��
		View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
		TextView answerContent = (TextView) view.findViewById(R.id.answer_content);
		TextView answerAnswerer = (TextView) view.findViewById(R.id.answer_answerer);
		answerContent.setText(answer.getAnswerContent());
		answerAnswerer.setText("���ߣ�" + answer.getAnswerAnswerer());
		return view;
	}
}