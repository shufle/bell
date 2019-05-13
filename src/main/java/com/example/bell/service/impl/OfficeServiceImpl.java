package com.example.bell.service.impl;

import com.example.bell.service.OfficeService;
import com.example.bell.view.*;
import com.example.bell.view.Office.OfficeFilter;
import com.example.bell.view.Office.OfficeView;
import com.example.bell.view.Office.SaveOfficeInfo;
import com.example.bell.view.Office.UpdateOfficeInfo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OfficeServiceImpl implements OfficeService {
    @Override
    public List<OfficeView> list(OfficeFilter filter) {
        return null;
    }

    @Override
    public OfficeView getOfficeById(Long id) {
        return null;
    }

    @Override
    public ResultView updateOffice(UpdateOfficeInfo info) {
        return null;
    }

    @Override
    public ResultView saveOffice(SaveOfficeInfo info) {
        return null;
    }
}
