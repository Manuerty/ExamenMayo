package edu.badpals;

import edu.badpals.domain.MagicalItem;
import edu.badpals.domain.Order;
import edu.badpals.domain.Wizard;
import edu.badpals.repository.MagicalItemRepository;
import edu.badpals.repository.OrderRepository;
import edu.badpals.repository.WizardRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class Repositorio {

        @Inject
        WizardRepository wizardRepo;

        @Inject
        MagicalItemRepository magicalItemRepo;

        @Inject
        OrderRepository orderRepo;

}
