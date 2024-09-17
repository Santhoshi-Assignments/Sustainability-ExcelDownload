package com.ust.project.sustainability.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class GoalAnswers {
    public String questionId;
    public ArrayList<Response> response;

}
