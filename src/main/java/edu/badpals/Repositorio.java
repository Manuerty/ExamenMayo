package edu.badpals;

import edu.badpals.domain.MagicalItem;
import edu.badpals.domain.Order;
import edu.badpals.domain.Wizard;
import edu.badpals.domain.WizardType;
import edu.badpals.repository.MagicalItemRepository;
import edu.badpals.repository.OrderRepository;
import edu.badpals.repository.WizardRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;


import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class Repositorio {


        @Inject
        WizardRepository wizardRepo;

        @Inject
        MagicalItemRepository magicalItemRepo;

        @Inject
        OrderRepository orderRepo;

        public Repositorio(){}

        public Optional<Wizard> loadWizard(String name) {
                Optional<Wizard> wizard = wizardRepo.findByIdOptional(name);
                return Optional.ofNullable(wizard.isPresent() ? wizard.get() : null);
        }

        public Optional<MagicalItem> loadItem(String name) {
                Optional<MagicalItem> item = magicalItemRepo.findByItemName(name);
                return Optional.ofNullable(item.isPresent() ? item.get() : null);
        }

        public Optional<MagicalItem> loadItem(MagicalItem MagicItem) {
                List <MagicalItem> items = loadItems(MagicItem.getName());
                for (MagicalItem item : items){
                        if (item.getName().equals(MagicItem.getName())
                                && item.getQuality() == MagicItem.getQuality()
                                && item.getType().equals(MagicItem.getType())){
                                return Optional.ofNullable(item);
                        }
                }
                return Optional.ofNullable(null);
        }

        public List<MagicalItem> loadItems(String name) {
                return this.magicalItemRepo.list("name", name);
        }

        @Transactional
        public Optional<Order> placeOrder( String wizardName, String itemName){
                Order orden = null;
                Optional<Wizard> wizard = loadWizard(wizardName);
                Optional<MagicalItem> item = loadItem(itemName);
                if (wizard.isPresent() && item.isPresent() && !wizard.get().getPerson().equals(WizardType.MUDBLOOD)){
                        orden = new Order();
                        orden.setWizard(wizard.get());
                        orden.setItem(item.get());
                        this.orderRepo.persist(orden);
                }
                return Optional.ofNullable(orden);
        }

        @Transactional
        public void createItem( String itemName, int quality, String itemType){
                MagicalItem item = new MagicalItem(itemName, quality, itemType);
                this.magicalItemRepo.persist(item);
        }

        @Transactional
        public void createItems(List<MagicalItem> items){
                this.magicalItemRepo.persist(items);
        }

        @Transactional
        public void deleteItem(MagicalItem item){
                Optional<MagicalItem> itemToDelete = loadItem(item);
                if (itemToDelete.isPresent()){
                        this.magicalItemRepo.delete(itemToDelete.get());
                }
        }





}
