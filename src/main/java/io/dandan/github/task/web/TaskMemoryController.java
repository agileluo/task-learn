package io.dandan.github.task.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.dandan.github.task.vo.Task;

/**
 * 任务列表(增删改查) - 内存实现
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/task")
public class TaskMemoryController {
	
	
	private List<Task> tasks = new ArrayList<>();
	
	/**
	 * 查询列表
	 * @return
	 */
	@RequestMapping("/list")
	public List<Task> listAll(){
		return tasks;
	}
	
	/**
	 * 增加任务
	 * @param task
	 * @return
	 */
	@RequestMapping("/add")
	public boolean add(Task task) {
		if(task.getId() == null) {
			throw new IllegalArgumentException("id不能为空");
		}
		if(StringUtils.isEmpty(task.getText())) {
			throw new IllegalArgumentException("text不能为空");
		}
		this.tasks.add(task);
		return true;
	}
	
	/**
	 * 删除任务
	 * @param task
	 * @return
	 */
	@RequestMapping("/del")
	public boolean del(final Long id) {
		for(int i = 0; i < tasks.size(); i++) {
			if(tasks.get(i).getId().equals(id)) {
				tasks.remove(i);
				return true;
			}
		}
		return false;
	}
	/**
	 * 更新任务
	 * @param task
	 * @return
	 */
	@RequestMapping("/update")
	public boolean update(final Task task) {
		if(task.getId() == null) {
			throw new IllegalArgumentException("id不能为空");
		}
		if(StringUtils.isEmpty(task.getText())) {
			throw new IllegalArgumentException("text不能为空");
		}
		for(int i = 0; i < tasks.size(); i++) {
			if(tasks.get(i).getId().equals(task.getId())) {
				tasks.set(i, task);
				return true;
			}
		}
		return false;
	}
	/**
	 * 根据id获取任务
	 * @param task
	 * @return
	 */
	@RequestMapping("/get")
	public Task getById(final Long id) {
		for(Task t : tasks) {
			if(t.getId().equals(id)) {
				return t;
			}
		}
		return null;
	}
	/**
	 * 根据文本匹配任务
	 * @param task
	 * @return
	 */
	@RequestMapping("/queryByText")
	public List<Task> queryByText( String text) {
		List<Task> result = new ArrayList<>();
		for(Task t : tasks) {
			if(t.getText().contains(text)) {
				result.add(t);
			}
		}
		return result;
	}
}
