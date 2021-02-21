package nl.novi.lindeboom.web2packflow.payload.response;

import nl.novi.lindeboom.web2packflow.domain.OrderItem;
import java.util.List;

public class BatchOverviewResponse {

    private Long id;
    private boolean open = true;
    private String substrateId;
    private String finishName;
    private List<OrderItem> orderItems ;


}
