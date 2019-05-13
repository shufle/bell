package com.example.bell.service;

import com.example.bell.view.*;
import com.example.bell.view.Office.OfficeFilter;
import com.example.bell.view.Office.OfficeView;
import com.example.bell.view.Office.SaveOfficeInfo;
import com.example.bell.view.Office.UpdateOfficeInfo;

import java.util.List;

public interface OfficeService {

    /**
     * Вывести список офисов по фильтру
     * @param filter данные запроса
     */
    List<OfficeView> list(OfficeFilter filter);

    /**
     * Возвращает офис по Id
     * @param id id в строке запроса
     */
    OfficeView getOfficeById(Long id);

    /**
     * Обновляет информацию об офисе
     * @param info данные запроса
     * @return success/failure
     */
    ResultView updateOffice(UpdateOfficeInfo info);

    /**Добавляет офис
     * @param info параметры запроса
     * @return  success/failure
     */
    ResultView saveOffice(SaveOfficeInfo info);
}
