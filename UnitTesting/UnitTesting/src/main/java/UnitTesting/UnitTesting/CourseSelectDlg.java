package UnitTesting.UnitTesting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public class CourseSelectDlg extends JDialog {
	private static final long serialVersionUID = 1L;
	// 0 HighLevel presentation 1 LowLevel presentation
	ClassCourseList theCourseList;
	Course selectedCourse;
	int nCourseLevel = 0;
	boolean mbLogout = false;
	JComboBox courseNameCom = new JComboBox();
	JRadioButton highLevelRadio = new JRadioButton();
	JRadioButton lowLevelRadio = new JRadioButton();
	JLabel jLabel1 = new JLabel();
	JButton oKButton = new JButton();
	ButtonGroup buttonGroup1 = new ButtonGroup();
	JButton buttonLogout = new JButton();

	public CourseSelectDlg() {
		try {
			jbInit();
			setSize(420, 238);
			setModal(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.getContentPane().setLayout(null);
		courseNameCom.setBounds(new Rectangle(155, 41, 203, 22));
		highLevelRadio.setText("HighLevel");
		highLevelRadio.setBounds(new Rectangle(50, 87, 103, 26));
		lowLevelRadio.setToolTipText("");
		lowLevelRadio.setSelected(true);
		lowLevelRadio.setText("LowLevel");
		lowLevelRadio.setBounds(new Rectangle(236, 88, 103, 26));
		jLabel1.setText("CourseName");
		jLabel1.setBounds(new Rectangle(39, 44, 85, 18));
		oKButton.setText("OK");
		oKButton.setBounds(new Rectangle(78, 139, 79, 29));
		oKButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oKButtonactionPerformed(e);
			}
		});
		buttonLogout.setText("Logout");
		buttonLogout.setBounds(new Rectangle(224, 140, 73, 31));
		buttonLogout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonLogout_actionPerformed(e);
			}
		});
		this.getContentPane().add(courseNameCom, null);
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(highLevelRadio, null);
		this.getContentPane().add(lowLevelRadio, null);
		this.getContentPane().add(oKButton, null);
		this.getContentPane().add(buttonLogout, null);
		buttonGroup1.add(highLevelRadio);
		buttonGroup1.add(lowLevelRadio);
	}

	/*
	 * show the theCourseList in a combox Show the Course type selection button
	 * return the pointer pointing to the Course object return the Course Type
	 */

	@SuppressWarnings("unchecked")
	public Course showDlg(ClassCourseList courseList) {

		theCourseList = courseList;
		CourseIterator theIterator = new CourseIterator(theCourseList);
		Course theCourse;
		while ((theCourse = (Course) theIterator.next()) != null) /// end of the list
		{
			courseNameCom.addItem(theCourse);
		}
		setVisible(true);
		return selectedCourse;
	}

	void oKButtonactionPerformed(ActionEvent e) {
		selectedCourse = (Course) courseNameCom.getSelectedItem();
		if (highLevelRadio.isSelected())
			nCourseLevel = 0; // highlevel course: 0
		else
			nCourseLevel = 1; // lowlevel course: 1
		setVisible(false);
	}

	public boolean isLogout() {
		return mbLogout;
	}

	void buttonLogout_actionPerformed(ActionEvent e) {
		mbLogout = true;
		setVisible(false);
	}
}