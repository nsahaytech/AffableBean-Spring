package affableBean.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import affableBean.domain.Member;
import affableBean.domain.PaymentInfo;

@Service
public class ValidatorService {

    // ensures that quantity input is number between 0 and 99
    // applies to quantity fields in cart page
    public boolean validateQuantity (String productId, String quantity) {

        boolean errorFlag = false;

        if (!productId.isEmpty() && !quantity.isEmpty()) {

            int i = -1;

            try {

                i = Integer.parseInt(quantity);
            } catch (NumberFormatException nfe) {

                System.out.println("User did not enter a number in the quantity field");
            }

            if (i < 0 || i > 99) {

                errorFlag = true;
            }
        }

        return errorFlag;
    }


    // performs simple validation on checkout form
    public boolean validateForm(String name,
//                                String phone,
                                String address,
                                String cityRegion,
                                String ccNumber,
                                HttpServletRequest request) {

        boolean errorFlag = false;
        boolean nameError;
//        boolean emailError;
//        boolean phoneError;
        boolean addressError;
        boolean cityRegionError;
        boolean ccNumberError;

        if (name == null
                || name.equals("")
                || name.length() > 45) {
            errorFlag = true;
            nameError = true;
            request.setAttribute("nameError", nameError);
        }
//        if (email == null
//                || email.equals("")
//                || !email.contains("@")) {
//            errorFlag = true;
//            emailError = true;
//            request.setAttribute("emailError", emailError);
//        }
//        if (phone == null
//                || phone.equals("")
//                || phone.length() < 9) {
//            errorFlag = true;
//            phoneError = true;
//            request.setAttribute("phoneError", phoneError);
//        }
        if (address == null
                || address.equals("")
                || address.length() > 45) {
            errorFlag = true;
            addressError = true;
            request.setAttribute("addressError", addressError);
        }
        if (cityRegion == null
                || cityRegion.equals("")
                || cityRegion.length() > 45) {
            errorFlag = true;
            cityRegionError = true;
            request.setAttribute("cityRegionError", cityRegionError);
        }
        if (ccNumber == null
                || ccNumber.equals("")
                || ccNumber.length() > 19) {
            errorFlag = true;
            ccNumberError = true;
            request.setAttribute("ccNumberError", ccNumberError);
        }

        return errorFlag;
    }
    
    // performs simple validation on checkout form
    public boolean validateMember(Member customer, 
//    		PaymentInfo paymentInfo,
                                HttpServletRequest request) {

        boolean errorFlag = false;
        boolean nameError;
        boolean emailError;
        boolean phoneError;
        boolean addressError;
        boolean cityRegionError;
//        boolean ccNumberError;
        
        String name = customer.getName();
        String email = customer.getEmail();
        String phone = customer.getPhone();
        String address = customer.getAddress();
        String cityRegion = customer.getCityRegion();
//        String ccNumber = paymentInfo.getCcNumber();

        if (name == null
                || name.equals("")
                || name.length() > 45) {
            errorFlag = true;
            nameError = true;
            request.setAttribute("nameError", nameError);
        }
        if (email == null
                || email.equals("")
                || !email.contains("@")) {
            errorFlag = true;
            emailError = true;
            request.setAttribute("emailError", emailError);
        }
        if (phone == null
                || phone.equals("")
                || phone.length() < 9) {
            errorFlag = true;
            phoneError = true;
            request.setAttribute("phoneError", phoneError);
        }
        if (address == null
                || address.equals("")
                || address.length() > 45) {
            errorFlag = true;
            addressError = true;
            request.setAttribute("addressError", addressError);
        }
        if (cityRegion == null
                || cityRegion.equals("")
                || cityRegion.length() > 45) {
            errorFlag = true;
            cityRegionError = true;
            request.setAttribute("cityRegionError", cityRegionError);
        }
//        if (ccNumber == null
//                || ccNumber.equals("")
//                || ccNumber.length() > 19) {
//            errorFlag = true;
//            ccNumberError = true;
//            request.setAttribute("ccNumberError", ccNumberError);
//        }

        return errorFlag;
    }

}