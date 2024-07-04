package lk.ijse.payment_service.service;

import lk.ijse.payment_service.dto.PaymentDto;
import lk.ijse.payment_service.entity.Payment;
import lk.ijse.payment_service.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public void createPayment(PaymentDto paymentDto) {
//        setPaidStatus(paymentDto.getTicketId());

        Payment payment = Payment.builder()
                .paymentId(paymentDto.getPaymentId())
                .ticketId(paymentDto.getTicketId())
                .userId(paymentDto.getUserId())
                .amount(paymentDto.getAmount())
                .paymentDate(paymentDto.getPaymentDate())
                .build();

        paymentRepository.save(payment);
    }
}
