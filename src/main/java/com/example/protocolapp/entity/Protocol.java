package com.example.protocolapp.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Protocols")
@Data
public class Protocol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "protocols_id")
    private Long id;
    // название выборов
    @Column(name = "protocols_name_election")
    private String nameElection;
    //Дата выборов
    @Column(name = "protocols_date_voting")
    @JsonFormat(pattern = "dd-mm-yyyy" )
    private Date votingDate;
    // Дата подписания протокола
    @Column(name = "protocols_date_of_signing_protocol")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime dateOfSigningProtocol;
    //количество избирателей в списке на момент окончания голосования
    @Column(name = "protocols_number_of_voters_on_list_at_end_of_voting")
    private Long numberOfVotersOnListAtEndOfVoting;
    //количество_бюллетеней_полученных_комиссией_участка
    @Column(name = "protocols_number_of_ballots_received_by_the_precinct_commission")
    private Long numberOfBallotsReceivedByPrecinctCommission;
    //число бюллетеней выданных проголосовавшим досрочно
    @Column(name = "protocols_number_of_ballots_issued_to_early_voters")
    private Long numberOfBallotsIssuedToEarlyVoters;
    //число бюллетени выданных в помешении для голосовании
    @Column(name = "protocols_number_of_ballots_issued_at_polling_station")
    private Long numberOfBallotsIssuedAtPollingStation;
    //число бюллетеней выданных проголосовавшим вне помещения
    @Column(name = "protocols_number_of_ballots_issued_to_those_who_voted_outside")
    private Long numberOfBallotsIssuedToThoseWhoVotedOutside;
    //число погашенных бюлетеней
    @Column(name = "protocols_number_of_canceled_ballots")
    private Long numberOfCanceledBallots;
    //7
    //число бюлетеней в переносных ящиках
    @Column(name = "protocols_number_of_ballots_in_portable_boxes")
    private Long numberOfBallotsInPortableBoxes;
    //8
    //число бюлетеней в стационарных ящиках
    @Column(name = "protocols_number_of_ballots_in_stationary_boxes")
    private Long numberOfBallotsInStationaryBoxes;
    //число недествительных бюлетеней
    @Column(name = "protocols_number_of_invalid_ballots")
    private Long numberOfInvalidBallots;
    //число действительных бюлетеней
    @Column(name = "protocols_number_of_valid_ballots")
    private Long numberOfValidBallots;
    //число утраченных бюлетеней
    @Column(name = "protocols_number_of_lost_ballots")
    private Long numberOfLostBallots;
    //число бюлетеней не учтенных при получении
    @Column(name = "protocols_number_of_ballots_not_taken_into_account_upon_receipt")
    private Long numberOfBallotsNotTakenIntoAccountUponReceipt;
    @OneToMany(mappedBy = "protocol", cascade = {CascadeType.ALL})
    @Column(name = "protocols_candidatsId")
    @JsonManagedReference
    private List<Candidates> candidates;

    public void addCandidates(Candidates candidate){
        if(candidates == null){
            candidates = new ArrayList<>();
        }
        DecimalFormat dF = new DecimalFormat( "#.##" );
        candidate.setPercentageOftheVote(candidate.getNumberOfVotes()
                /((this.getNumberOfBallotsInPortableBoxes() +
                this.getNumberOfBallotsInStationaryBoxes())
                *0.01));
        candidate.setProtocol(this);
    }


}
