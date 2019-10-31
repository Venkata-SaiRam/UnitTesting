package UnitTesting.UnitTesting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
abstract public class CourseMenu extends JDialog {
	private static final long serialVersionUID = 1L;
	Course theCourse;
	boolean bLogout = true;

	JRadioButton assignmentRadiao = new JRadioButton();
	JComboBox assignmentCombox = new JComboBox();
	JButton assignmentViewButton = new JButton();
	JButton assignmentAddButton = new JButton();
	JRadioButton optionRadio = new JRadioButton();
	JLabel assignmentContentLable = new JLabel();
	JComboBox optionCombo = new JComboBox();
	JButton optionViewButton = new JButton();
	JButton optionAddButton = new JButton();
	JButton buttonChangeCourse = new JButton();
	JButton buttonLogout = new JButton();

	public CourseMenu() {

		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setModal(true);
		setSize(503, 294);
	}

	private void jbInit() throws Exception {
		buttonChangeCourse.setText("ChangeCourse");
		buttonChangeCourse.setBounds(new Rectangle(101, 211, 73, 37));
		buttonChangeCourse.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonChangeCourseactionPerformed(e);
			}
		});
		this.getContentPane().setLayout(null);
		this.setTitle("");
		buttonLogout.setText("Logout");
		buttonLogout.setBounds(new Rectangle(267, 215, 73, 37));
		buttonLogout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonLogoutactionPerformed(e);
			}
		});
		this.getContentPane().add(buttonChangeCourse, null);
		this.getContentPane().add(buttonLogout, null);
	}

	/*
	 * when the add button is pressed, call add assignment function of facade, after
	 * that refresh window
	 */

	/*
	 * when the add button is pressed, call ViewAssignment function of facade, after
	 * that refresh window
	 */

	abstract void ShowMenu(Course theCourse);

	abstract void ShowAddButtons();

	abstract void ShowViewButtons();

	abstract void ShowRadios();

	abstract void ShowComboxes();

	abstract void ShowLabel();

	void assignmentAddButtonactionPerformed(ActionEvent e) {
		Hacs.theFacade.addAssignment(theCourse);
		refresh();
	}

	void assignmentViewButtonactionPerformed(ActionEvent e) {
		Assignment theAssignment = (Assignment) assignmentCombox.getSelectedItem();
		Hacs.theFacade.viewAssignment(theAssignment);
	}

	@SuppressWarnings("unchecked")
	void refresh() {
		assignmentCombox.removeAllItems();
		Iterator Iteration = theCourse.assignmentList.iterator();
		while (Iteration.hasNext()) {
			assignmentCombox.addItem(Iteration.next());
		}
	}

	void buttonChangeCourseactionPerformed(ActionEvent e) {
		bLogout = false;
		setVisible(false);
	}

	void buttonLogoutactionPerformed(ActionEvent e) {
		bLogout = true;
		setVisible(false);
	}

	boolean ifLogout() {
		return bLogout;
	}
}