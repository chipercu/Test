package org.example.MonitoringRefactoring;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class Yandex {

//    @TmsLink("AM-T143")
//    @Test(description = "")
//    public void AM_T143() {
//        startTestTime();
//    action(DesktopElement::click, findEditByName("Адресная строка и строка поиска"))
//            .enterText("Сравнение текстов онлайн <http://text.num2word.ru/> ")
//                .pressKey(Keys.ENTER)
//                .action(DesktopElement::click, findHyperLinkByName(" Сравнение текстов онлайн num2word.ru http://text.num2word.ru"))
//            .action(DesktopElement::click, findEditById("text1"))
//            .setText("qwerty")
//                .sendKeyCombination(CTRL_SHIFT_HOME)
//                .sendKeyCombination(CTRL_C)
//                .action(DesktopElement::click, findEditById("text2"))
//            .sendKeyCombination(CTRL_V)
//                .sendKeyCombination(CTRL_SHIFT_HOME)
//                .sendKeyCombination(CTRL_X)
//                .action(DesktopElement::click, findEditById("text1"))
//            .sendKeyCombination(CTRL_SHIFT_HOME)
//                .action(DesktopElement::rightClick, findEditById("text1"))
//            .action(DesktopElement::click, findMenuItemByName("КопироватьCtrl + C"))
//            .action(DesktopElement::click, findEditById("text2"))
//            .action(DesktopElement::rightClick, findEditById("text2"))
//            .action(DesktopElement::click, findMenuItemByName("ВставитьCtrl + V"))
//            .sendKeyCombination(CTRL_SHIFT_HOME)
//                .action(DesktopElement::rightClick, findEditById("text2"))
//            .action(DesktopElement::click, findMenuItemByName("ВырезатьCtrl + X"));
//
//        finishTestTime();
//}



//    @TmsLink("AM-T144")
//    @Test(description = "Фиксирование дочерних окон с AriaRole = dialog и действия в таких окнах.")
//    public void AM_T144() {
//        startTestTime();
//        action(DesktopElement::click, findEditByName("Адресная строка и строка поиска"))
//                .enter("https://configurator.bitrixdemo.ru/configurators/pc/")
//                .pressKey(Keys.ENTER)
//                .action(DesktopElement::click, findButtonByName("Выбрать"));
//        DesktopDriver.emptyWait(6000);
//        action(DesktopElement::click, findEditById("arrFilter_P1_MIN"))
//                .sendKeyCombination(CTRL_A_DELETE)
//                .findEditById("arrFilter_P1_MIN").setText("1000");
//        action(DesktopElement::click, findTextByName("Asus ("))
//                .action(DesktopElement::click, findTextByName("GIGABYTE ("))
//                .action(DesktopElement::click, findTextByName("GIGABYTE ("))
//                .pressKey(Keys.END)
//                .action(DesktopElement::click, findButtonById("del_filter"))
//                .pressKey(Keys.HOME)
//                .action(DesktopElement::click, findComboBoxById("sort_change"))
//                .action(DesktopElement::click, findListItemByName("название - по убыванию"))
//                .action(DesktopElement::click, findGroupById("yandex-image-buttons-main-container"))
//                .action(DesktopElement::click, findHyperLinkById("quick_view_back"));
//        finishTestTime();
//    }




}
