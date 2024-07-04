package lk.ijse.payment_service.controller;

import lk.ijse.payment_service.dto.PaymentDto;
import lk.ijse.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/health")
    public String healthCheck(){
        return "payment HealthCheck success";
    }

    @PostMapping
    public ResponseEntity<?> createPayment(@RequestBody PaymentDto paymentDto){
        paymentService.createPayment(paymentDto);
        return ResponseEntity.ok("Payment saved successfully");
    }
}
