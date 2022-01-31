package com.main.helpers;

import com.main.model.response.ResponseBase;

import java.util.List;


    public class PaginatedListResponse<T> extends ResponseBase {

        private String CurrentPage;
        private String TotalItems;

        public String getCurrentPage() {
            return CurrentPage;
        }
        public void setCurrentPage(String currentPage) {
            CurrentPage = currentPage;
        }

        public String getTotalItems() {
            return TotalItems;
        }

        public void setTotalItems(String totalItem) {
            TotalItems = totalItem;
        }

        public List<T> getItems() {
            return items;
        }

        public void setItems(List<T> items) {
            this.items = items;
        }

        public Integer getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }

        private Integer totalPages;

        private List<T> items;



}
