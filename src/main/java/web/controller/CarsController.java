package web.controller;

import DAO.CarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {


    private CarDAO carDao;

    @Autowired
    public CarsController(CarDAO carDao) {
        this.carDao = carDao;
    }

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam int count, ModelMap model) {

        model.addAttribute("cars",carDao.getCarList(count));
        return "cars";
    }
}
