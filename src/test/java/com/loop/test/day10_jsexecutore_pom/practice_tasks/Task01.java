package com.loop.test.day10_jsexecutore_pom.practice_tasks;

import com.loop.pages.LoopCampPractice;
import com.loop.pages.LoopPracticeDragDropPage;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

//import static org.testng.Assert.assertEquals;

public class Task01 {
    /**
1. Open a chrome browser
2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
3. Click and hold small circle
4. Move it on top of the big circle
5. validate “Now drop…” text appears on big circ
     */

 LoopCampPractice loopCampPractice;
 Actions actions;

    @BeforeMethod

    public  void setupMethod(){
    Driver.getDriver().get("https://loopcamp.vercel.app/drag-and-drop-circles.html");
     loopCampPractice = new LoopCampPractice();
    actions = new Actions(Driver.getDriver());
}

/*
task2
1. Open a chrome browser
2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
3. Click and hold small circle
4. Dropped anywhere outside of big circle
5. validate “Try again!” text appears on big circle
 */
@Test(priority = 2)
    public void dragAndDropCircle(){
        actions.clickAndHold(loopCampPractice.smallCircle).moveToElement(loopCampPractice.bigCircle).perform();
        String expected= "Now drop...";
        String actual= loopCampPractice.bigCircle.getText();
    assertEquals(actual, expected, "Does NOT match");
}
@Test (priority = 1)
    public void dragAndDropAnywhere(){
        actions.clickAndHold(loopCampPractice.smallCircle).moveByOffset(300,300).release().perform();
        assertEquals(loopCampPractice.bigCircle.getText(), "Try again!", "Does NOT match");
}
}
